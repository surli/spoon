package spoon.test.modifiers;

import org.junit.Test;
import spoon.Launcher;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.ModifierKind;
import spoon.test.modifiers.testclasses.MethodVarArgs;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestModifiers {

    @Test
    public void testMethodWithVarargsDoesNotBecomeTransient() {
        // contract: method with varsargs should not become transient
        Launcher spoon = new Launcher();
        spoon.addInputResource("./src/test/java/spoon/test/modifiers/testclasses/MethodVarArgs.java");
        spoon.buildModel();

        CtType<?> myClass = spoon.getFactory().Type().get(MethodVarArgs.class);
        CtMethod methodVarargs = myClass.getMethodsByName("getInitValues").get(0);

        Set<ModifierKind> expectedModifiers = Collections.singleton(ModifierKind.PROTECTED);

        assertEquals(expectedModifiers, methodVarargs.getModifiers());

        spoon = new Launcher();
        spoon.addInputResource("./src/test/java/spoon/test/modifiers/testclasses/MethodVarArgs.java");
        spoon.getEnvironment().setShouldCompile(true);
        spoon.run();
    }

    @Test
    public void testCtModifiableAddRemoveReturnCtModifiable() {
        // contract: CtModifiable#addModifier and CtModifiable#removeModifier should return CtModifiable

        Launcher spoon = new Launcher();
        spoon.addInputResource("./src/test/java/spoon/test/modifiers/testclasses/MethodVarArgs.java");
        spoon.buildModel();

        CtType<?> myClass = spoon.getFactory().Type().get(MethodVarArgs.class);
        CtMethod methodVarargs = myClass.getMethodsByName("getInitValues").get(0);

        Object o = methodVarargs.addModifier(ModifierKind.FINAL);
        assertEquals(methodVarargs, o);

        o = methodVarargs.removeModifier(ModifierKind.FINAL);
        assertEquals(methodVarargs, o);
    }
}
