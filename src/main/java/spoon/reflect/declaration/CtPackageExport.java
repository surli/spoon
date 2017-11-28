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

import spoon.reflect.annotations.PropertyGetter;
import spoon.reflect.annotations.PropertySetter;
import spoon.reflect.path.CtRole;
import spoon.reflect.reference.CtModuleReference;
import spoon.reflect.reference.CtPackageReference;

import java.util.List;

/**
 * Represents an exported or opened package in a Java module
 * See: https://docs.oracle.com/javase/specs/jls/se9/html/jls-7.html#jls-7.7
 *
 * An opened package has an access granted only at runtime, contrary to an exported package
 * which is available at compile time and runtime.
 *
 * Examples:
 * <pre>
 *     exports com.example.foo.internal to com.example.foo.probe;
 *     opens com.example.foo.quux;
 * </pre>
 */
public interface CtPackageExport extends CtModuleDirective {

	@PropertySetter(role = CtRole.OPENED_PACKAGE)
	<T extends CtPackageExport> T setOpenedPackage(boolean openedPackage);

	@PropertyGetter(role = CtRole.OPENED_PACKAGE)
	boolean isOpenedPackage();

	@PropertyGetter(role = CtRole.PACKAGE_REF)
	CtPackageReference getPackageReference();

	@PropertySetter(role = CtRole.PACKAGE_REF)
	<T extends CtPackageExport> T setPackageReference(CtPackageReference packageReference);

	@PropertyGetter(role = CtRole.MODULE_REF)
	List<CtModuleReference> getTargetExport();

	@PropertySetter(role = CtRole.MODULE_REF)
	<T extends CtPackageExport> T setTargetExport(List<CtModuleReference> targetExport);

	@PropertySetter(role = CtRole.MODULE_REF)
	<T extends CtPackageExport> T addTargetExport(CtModuleReference targetExport);

	@Override
	CtPackageExport clone();
}
