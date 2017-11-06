/**
 * Copyright (C) 2006-2017 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 * <p>
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 * <p>
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.support.reflect;

import spoon.reflect.declaration.ModifierKind;

import java.io.Serializable;

public class CtExtendedModifier implements Serializable {
    private boolean implicit;
    private ModifierKind kind;

    public CtExtendedModifier(ModifierKind kind) {
        this.kind = kind;
    }

    public CtExtendedModifier(ModifierKind kind, boolean implicit) {
        this(kind);
        this.implicit = implicit;
    }

    public boolean isImplicit() {
        return implicit;
    }

    public void setImplicit(boolean implicit) {
        this.implicit = implicit;
    }

    public ModifierKind getKind() {
        return kind;
    }

    public void setKind(ModifierKind kind) {
        this.kind = kind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CtExtendedModifier that = (CtExtendedModifier) o;

        return (implicit == that.implicit && kind == that.kind);
    }

    @Override
    public int hashCode() {
        int result = (implicit ? 1 : 0);
        result = 31 * result + (kind != null ? kind.hashCode() : 0);
        return result;
    }
}
