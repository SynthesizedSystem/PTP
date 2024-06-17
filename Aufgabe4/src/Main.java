import aufgabe4.Wagen;
import aufgabe4.Zug;
import test.AttachTest;
import test.DetachTest;

public class Main {
    public static void main(String[] args) {
        runTests();
    }

    private static boolean testBoolean(boolean actual, boolean expected) {
        return actual == expected;
    }

    private static void runTests() {
        boolean testsResult = true;
        testsResult &= testEmptyTrain();
        testsResult &= testNotEqualTrains();
        testsResult &= testEqualTrains();

        if (testsResult)
            System.out.println("Tests passed.");
        else
            System.out.println("Tests failed.");
    }

    private static boolean testEmptyTrain() {
        Zug train1 = new Zug();
        Zug train2 = new Zug();

        boolean result = train1.vergleichen(train2);
        return !result;
    }

    private static boolean testNotEqualTrains() {
        Zug train1 = new Zug();
        Zug train2 = new Zug();

        Wagen[] wagons = new Wagen[]{ new Wagen(), new Wagen() };
        train1.anhaengen(wagons[0]);
        train2.anhaengen(wagons[1]);

        boolean result = train1.vergleichen(train2);
        return !result;
    }

    private static boolean testEqualTrains() {
        Zug train1 = new Zug();
        Zug train2 = new Zug();

        Wagen[] wagons = new Wagen[]{ new Wagen(), new Wagen() };
        train1.anhaengen(wagons[0]);
        train1.anhaengen(wagons[1]);
        train2.anhaengen(wagons[1]);

        boolean result = train1.vergleichen(train2);
        return result;
    }
}