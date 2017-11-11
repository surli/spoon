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
package spoon.reflect.reference;

import spoon.reflect.annotations.PropertyGetter;
import spoon.reflect.annotations.PropertySetter;
import spoon.reflect.declaration.CtElement;

import static spoon.reflect.path.CtRole.IMPORT_KIND;
import static spoon.reflect.path.CtRole.TARGET;

/**
 * This element represents an import declaration
 *
 * Example:
 * <pre>
 *     import java.io.File;
 * </pre>
 */
public interface CtImport extends CtElement {
	@PropertySetter(role = IMPORT_KIND)
	<T extends CtImport> T setImportKind(ImportKind importKind);

	@PropertyGetter(role = IMPORT_KIND)
	ImportKind getImportKind();

	@PropertyGetter(role = TARGET)
	CtReference getReference();

	@PropertySetter(role = TARGET)
	<T extends CtImport> T setReference(CtReference reference);

	String getSimpleName();
}
