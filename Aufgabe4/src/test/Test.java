package test;

import aufgabe4.Zug;

public class Test {
    protected static boolean assertEquals(Zug train, String expected, String message) {
        if (!train.toString().equals(expected)) {
            System.out.println(message);
            return false;
        }
        return true;
    }
}
