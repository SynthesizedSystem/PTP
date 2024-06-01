package test;

import aufgabe4.Train;

public class Test {
    protected static boolean assertEquals(Train train, String expected, String message) {
        if (!train.toString().equals(expected)) {
            System.out.println(message);
            return false;
        }
        return true;
    }
}
