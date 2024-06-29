package test;

import aufgabe4.Zug;
import aufgabe4.Wagen;
import strategies.AttachIterative;
import strategies.DetachIterative;

import static test.Test.assertEquals;

public class DetachTest {
    public static boolean runTests() {
        boolean testsResult = true;
        testsResult &= testIterativeDetachment();
        testsResult &= testFirstDetachment();
        return testsResult;
    }

    private static boolean testIterativeDetachment() {
        Zug train = new Zug(new AttachIterative(), new DetachIterative());
        Wagen[] wagons = new Wagen[]{new Wagen(), new Wagen(), new Wagen()};
        train.anhaengen(wagons[0]);
        train.anhaengen(wagons[1]);
        train.anhaengen(wagons[2]);

        train.abhaengen(wagons[1]);
        train.anhaengen(wagons[1]);

        Wagen.flushId();
        return assertEquals(train, "Train: 0->2->1->", "Failed iterative detachment test!");
    }

    private static boolean testFirstDetachment() {
        Zug train = new Zug(new AttachIterative(), new DetachIterative());
        Wagen[] wagons = new Wagen[]{new Wagen(), new Wagen(), new Wagen()};
        train.anhaengen(wagons[0]);
        train.anhaengen(wagons[1]);
        train.anhaengen(wagons[2]);

        train.abhaengen(wagons[0]);
        train.anhaengen(wagons[0]);

        Wagen.flushId();
        return assertEquals(train, "Train: 1->2->0->", "Failed first detachment test!");
    }
}
