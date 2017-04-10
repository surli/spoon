package spoon.test.imports.testclasses.other;

import spoon.test.imports.testclasses.other.my.StaticField;

/**
 * Created by urli on 10/04/2017.
 */
public class WorkingExample {
    public void literalConcat() {
        String r = "Hello:  " + StaticField.TEXT;
    }
}
