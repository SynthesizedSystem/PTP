package test;

import aufgabe4.Train;
import aufgabe4.Wagon;
import strategies.AttachIterative;
import strategies.DetachIterative;

import static test.Test.assertEquals;

public class DetachTest {
    public static boolean runTests() {
        boolean testsResult = true;
        testsResult &= testIterativeDetachment();
        testsResult &= testRecursiveDetachment();
        testsResult &= testFirstDetachment();
        return testsResult;
    }

    private static boolean testIterativeDetachment() {
        Train train = new Train(new AttachIterative(), new DetachIterative());
        Wagon[] wagons = new Wagon[]{new Wagon(), new Wagon(), new Wagon()};
        train.attachWagon(wagons[0]);
        train.attachWagon(wagons[1]);
        train.attachWagon(wagons[2]);

        train.detachWagon(wagons[1]);
        train.attachWagon(wagons[1]);

        Wagon.flushId();
        return assertEquals(train, "Train: 0->2->1->", "Failed iterative detachment test!");
    }

    private static boolean testRecursiveDetachment() {
        Train train = new Train(new AttachIterative(), new DetachIterative());
        Wagon[] wagons = new Wagon[]{new Wagon(), new Wagon(), new Wagon()};
        train.attachWagon(wagons[0]);
        train.attachWagon(wagons[1]);
        train.attachWagon(wagons[2]);

        train.detachWagon(wagons[1]);
        train.attachWagon(wagons[1]);

        Wagon.flushId();
        return assertEquals(train, "Train: 0->2->1->", "Failed recursive detachment test!");
    }

    private static boolean testFirstDetachment() {
        Train train = new Train(new AttachIterative(), new DetachIterative());
        Wagon[] wagons = new Wagon[]{new Wagon(), new Wagon(), new Wagon()};
        train.attachWagon(wagons[0]);
        train.attachWagon(wagons[1]);
        train.attachWagon(wagons[2]);

        train.detachWagon(wagons[0]);
        train.attachWagon(wagons[0]);

        Wagon.flushId();
        return assertEquals(train, "Train: 1->2->0->", "Failed first detachment test!");
    }
}
