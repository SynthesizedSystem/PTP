package test;

import aufgabe4.Train;
import aufgabe4.Wagon;
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
        Train train = new Train();
        return assertEquals(train, "Train: ", "Failed empty train test!");
    }

    private static boolean testIterativeAttachment() {
        Train train = new Train();
        train.setAttachStrategy(new AttachIterative());
        Wagon[] wagons = new Wagon[]{new Wagon(), new Wagon(), new Wagon()};
        train.attachWagon(wagons[0]);
        train.attachWagon(wagons[1]);
        train.attachWagon(wagons[2]);

        Wagon.flushId();
        return assertEquals(train, "Train: 0->1->2->", "Failed iterative attachment test!");
    }

    private static boolean testRecursiveAttachment() {
        Train train = new Train();
        train.setAttachStrategy(new AttachRecursive());
        Wagon[] wagons = new Wagon[]{new Wagon(), new Wagon(), new Wagon()};
        train.attachWagon(wagons[0]);
        train.attachWagon(wagons[1]);
        train.attachWagon(wagons[2]);

        Wagon.flushId();
        return assertEquals(train, "Train: 0->1->2->", "Failed recursive attachment test!");
    }
}
