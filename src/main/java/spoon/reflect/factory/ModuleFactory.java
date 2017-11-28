/**
 * Copyright (C) 2006-2017 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.factory;

import spoon.reflect.CtModelImpl;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtModule;
import spoon.reflect.declaration.CtPackageExport;
import spoon.reflect.declaration.CtProvidedService;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtUsedService;
import spoon.reflect.declaration.ParentNotInitializedException;
import spoon.reflect.reference.CtModuleReference;
import spoon.reflect.declaration.CtModuleRequirement;
import spoon.reflect.reference.CtPackageReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtVisitor;
import spoon.support.reflect.declaration.CtElementImpl;
import spoon.support.reflect.declaration.CtModuleImpl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ModuleFactory extends SubFactory implements Serializable {

	public static class CtUnnamedModule extends CtModuleImpl {
		final Map<String, CtModule> allModules = new HashMap<>();

		{
			this.setSimpleName(CtModule.TOP_LEVEL_MODULE_NAME);
			this.setParent(new CtElementImpl() {
				@Override
				public void accept(CtVisitor visitor) {

				}

				@Override
				public CtElement getParent() throws ParentNotInitializedException {
					return null;
				}

				@Override
				public Factory getFactory() {
					return CtUnnamedModule.this.getFactory();
				}
			});

			this.setRootPackage(new CtModelImpl.CtRootPackage());
			this.addModule(this);
		}

		public boolean addModule(CtModule module) {
			if (allModules.containsKey(module.getSimpleName())) {
				return false;
			}
			allModules.put(module.getSimpleName(), module);
			return true;
		}

		public CtModule getModule(String name) {
			return allModules.get(name);
		}

		public Collection<CtModule> getAllModules() {
			return Collections.unmodifiableCollection(allModules.values());
		}

		@Override
		public <T extends CtNamedElement> T setSimpleName(String name) {
			if (name == null) {
				return (T) this;
			}

			if (name.equals(CtModule.TOP_LEVEL_MODULE_NAME)) {
				return super.setSimpleName(name);
			}

			return (T) this;
		}

		@Override
		public String toString() {
			return CtModule.TOP_LEVEL_MODULE_NAME;
		}

		@Override
		public void accept(CtVisitor visitor) {
			visitor.visitCtModule(this);
			getFactory().Module().getAllModules().forEach(module -> {
				if (!module.getSimpleName().equals(CtModule.TOP_LEVEL_MODULE_NAME)) {
					module.accept(visitor);
				}
			});
		}
	}

	public ModuleFactory(Factory factory) {
		super(factory);
	}

	public CtUnnamedModule getUnnamedModule() {
		return (CtUnnamedModule) factory.getModel().getUnnamedModule();
	}

	public Collection<CtModule> getAllModules() {
		return getUnnamedModule().getAllModules();
	}

	public CtModule getModule(String moduleName) {
		return getUnnamedModule().getModule(moduleName);
	}

	public CtModule getOrCreate(String moduleName) {
		if (moduleName == null || moduleName.isEmpty()) {
			return getUnnamedModule();
		}

		CtModule ctModule = getUnnamedModule().getModule(moduleName);
		if (ctModule == null) {
			ctModule = factory.Core().createModule().setSimpleName(moduleName).setParent(getUnnamedModule());
			getUnnamedModule().addModule(ctModule);
		}

		return ctModule;
	}

	public CtModuleReference createReference(CtModule module) {
		return factory.Core().createModuleReference().setSimpleName(module.getSimpleName());
	}

	public CtModuleRequirement createModuleRequirement(CtModuleReference moduleReference) {
		return factory.Core().createModuleRequirement().setModuleReference(moduleReference);
	}

	public CtPackageExport createPackageExport(CtPackageReference ctPackageReference) {
		return factory.Core().createPackageExport().setPackageReference(ctPackageReference);
	}

	public CtProvidedService createProvidedService(CtTypeReference typeReference) {
		return factory.Core().createProvidedService().setServiceType(typeReference);
	}

	public CtUsedService createUsedService(CtTypeReference typeReference) {
		return factory.Core().createUsedService().setServiceType(typeReference);
	}
}
