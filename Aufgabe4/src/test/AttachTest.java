package test;

import aufgabe4.Zug;
import aufgabe4.Wagen;
import strategies.AttachIterative;
import strategies.AttachRecursive;

public class AttachTest extends Test {
    public static boolean runTests() {
        boolean testsResult = true;
        testsResult &= testEmptyTrain();
        testsResult &= testIterativeAttachment();
        testsResult &= testRecursiveAttachment();
        return testsResult;
    }

    private static boolean testEmptyTrain() {
        Zug train = new Zug();
        return assertEquals(train, "Train: ", "Failed empty train test!");
    }

    private static boolean testIterativeAttachment() {
        Zug train = new Zug();
        train.setAttachStrategy(new AttachIterative());
        Wagen[] wagons = new Wagen[]{new Wagen(), new Wagen(), new Wagen()};
        train.anhaengen(wagons[0]);
        train.anhaengen(wagons[1]);
        train.anhaengen(wagons[2]);

        Wagen.flushId();
        return assertEquals(train, "Train: 0->1->2->", "Failed iterative attachment test!");
    }

    private static boolean testRecursiveAttachment() {
        Zug train = new Zug();
        train.setAttachStrategy(new AttachRecursive());
        Wagen[] wagons = new Wagen[]{new Wagen(), new Wagen(), new Wagen()};
        train.anhaengen(wagons[0]);
        train.anhaengen(wagons[1]);
        train.anhaengen(wagons[2]);

        Wagen.flushId();
        return assertEquals(train, "Train: 0->1->2->", "Failed recursive attachment test!");
    }
}
