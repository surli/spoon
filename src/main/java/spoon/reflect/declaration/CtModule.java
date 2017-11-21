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
package spoon.reflect.declaration;

import spoon.reflect.reference.CtModuleProvidedService;
import spoon.reflect.reference.CtModuleReference;
import spoon.reflect.reference.CtTypeReference;

import java.util.List;

public interface CtModule extends CtNamedElement {

	/**
	 * The name for the top level module.
	 */
	String TOP_LEVEL_MODULE_NAME = "unnamed module";

	boolean isUnnamedModule();

	boolean isOpenModule();

	<T extends CtModule> T setIsOpenModule(boolean openModule);

	List<CtTypeReference> getConsumedServices();

	<T extends CtModule> T setConsumedServices(List<CtTypeReference> consumedServices);

	List<CtModuleExport> getExportedPackages();

	<T extends CtModule> T setExportedPackages(List<CtModuleExport> exportedPackages);

	List<CtModuleExport> getOpenedPackages();

	<T extends CtModule> T setOpenedPackages(List<CtModuleExport> openedPackages);

	List<CtModuleRequirement> getRequiredModules();

	<T extends CtModule> T setRequiredModules(List<CtModuleRequirement> requiredModules);

	List<CtModuleProvidedService> getProvidedServices();

	<T extends CtModule> T setProvidedServices(List<CtModuleProvidedService> providedServices);

	CtPackage getRootPackage();

	<T extends CtModule> T setRootPackage(CtPackage rootPackage);

	@Override
	CtModuleReference getReference();
}
