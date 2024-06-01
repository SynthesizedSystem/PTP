import aufgabe4.Train;
import aufgabe4.Wagon;
import strategies.AttachIterative;
import strategies.AttachRecursive;
import strategies.DetachIterative;
import test.AttachTest;
import test.DetachTest;

public class Main {
    public static void main(String[] args) {
        boolean testsResult = true;
        testsResult &= AttachTest.runTests();
        testsResult &= DetachTest.runTests();

        if (testsResult) {
            System.out.println("Tests passed.");
        } else {
            System.out.println("Tests failed.");
        }
    }
}