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

public interface CtModuleExport extends CtElement {

	@PropertyGetter(role = CtRole.PACKAGE_REF)
	CtPackageReference getPackageReference();

	@PropertySetter(role = CtRole.PACKAGE_REF)
	<T extends CtModuleExport> T setPackageReference(CtPackageReference packageReference);

	@PropertyGetter(role = CtRole.MODULE_REF)
	List<CtModuleReference> getTargetExport();

	@PropertySetter(role = CtRole.MODULE_REF)
	<T extends CtModuleExport> T setTargetExport(List<CtModuleReference> targetExport);

	@PropertySetter(role = CtRole.MODULE_REF)
	<T extends CtModuleExport> T addTargetExport(CtModuleReference targetExport);

	@Override
	CtModuleExport clone();
}
