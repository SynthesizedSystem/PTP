public class Main {
    public static void main(String[] args) {
        if (runTests()) {
            System.out.println("All tests passed");
        } else {
            System.out.println("Some tests failed");
        }
    }

    private static boolean testString(String expected, String actual) {
        if (expected.equals(actual)) {
            return true;
        } else {
            System.out.println(expected + " != " + actual);
            return false;
        }
    }

    private static boolean testBoolean(boolean expected, boolean actual) {
        return expected == actual;
    }

    private static boolean runTests() {
        boolean testsResult = true;
        testsResult &= testEingangTrue();
        testsResult &= testEingangFalse();

        testsResult &= testGatterNichtTrue();
        testsResult &= testGatterNichtFalse();

        testsResult &= testBinaeresGatterNullReference();
        testsResult &= testBinaeresGatterUndTrue();
        testsResult &= testBinaeresGatterUndFalse();
        testsResult &= testBinaeresGatterOderTrue();
        testsResult &= testBinaeresGatterOderFalse();
        testsResult &= testBinaeresGatterXorTrue();
        testsResult &= testBinaeresGatterXorFalse();

        testsResult &= testComplexExpression();

        return testsResult;
    }

    private static boolean testEingangTrue() {
        Gatter eingang = new Eingang(true);
        return testString("WAHR", eingang.toString())
                && testBoolean(true, eingang.getOutput());
    }

    private static boolean testEingangFalse() {
        Gatter eingang = new Eingang(false);
        return testString("FALSCH", eingang.toString())
                && testBoolean(false, eingang.getOutput());
    }

    private static boolean testGatterNichtTrue() {
        GatterNicht gatterNicht = new GatterNicht();
        gatterNicht.eingang = new Eingang(true);
        return testString("(NICHT WAHR)", gatterNicht.toString())
                && testBoolean(false, gatterNicht.getOutput());
    }

    private static boolean testGatterNichtFalse() {
        GatterNicht gatterNicht = new GatterNicht();
        gatterNicht.eingang = new Eingang(false);
        return testString("(NICHT FALSCH)", gatterNicht.toString())
                && testBoolean(true, gatterNicht.getOutput());
    }

    private static boolean testBinaeresGatterNullReference() {
        BinaeresGatter und = new BinaeresGatterUnd();
        und.eingaenge[0] = new Eingang(true);
        try {
            boolean temp = und.getOutput();
            return false;
        } catch (NullPointerException e) {
            return true;
        }
    }

    private static boolean testBinaeresGatterUndTrue() {
        BinaeresGatter und = new BinaeresGatterUnd();
        und.eingaenge[0] = new Eingang(true);
        und.eingaenge[1] = new Eingang(true);
        return testString("(WAHR UND WAHR)", und.toString())
                && testBoolean(true, und.getOutput());
    }

    private static boolean testBinaeresGatterUndFalse() {
        BinaeresGatter und = new BinaeresGatterUnd();
        und.eingaenge[0] = new Eingang(true);
        und.eingaenge[1] = new Eingang(false);
        return testString("(WAHR UND FALSCH)", und.toString())
                && testBoolean(false, und.getOutput());
    }

    private static boolean testBinaeresGatterOderTrue() {
        BinaeresGatter oder = new BinaeresGatterOder();
        oder.eingaenge[0] = new Eingang(true);
        oder.eingaenge[1] = new Eingang(false);
        return testString("(WAHR ODER FALSCH)", oder.toString())
                && testBoolean(true, oder.getOutput());
    }

    private static boolean testBinaeresGatterOderFalse() {
        BinaeresGatter oder = new BinaeresGatterOder();
        oder.eingaenge[0] = new Eingang(false);
        oder.eingaenge[1] = new Eingang(false);
        return testString("(FALSCH ODER FALSCH)", oder.toString())
                && testBoolean(false, oder.getOutput());
    }
    private static boolean testBinaeresGatterXorTrue() {
        BinaeresGatter xor = new BinaeresGatterXor();
        xor.eingaenge[0] = new Eingang(true);
        xor.eingaenge[1] = new Eingang(false);
        return testString("(WAHR XOR FALSCH)", xor.toString())
                && testBoolean(true, xor.getOutput());
    }

    private static boolean testBinaeresGatterXorFalse() {
        BinaeresGatter xor = new BinaeresGatterXor();
        xor.eingaenge[0] = new Eingang(true);
        xor.eingaenge[1] = new Eingang(true);
        return testString("(WAHR XOR WAHR)", xor.toString())
                && testBoolean(false, xor.getOutput());
    }

    private static boolean testComplexExpression() {
        BinaeresGatter und = new BinaeresGatterUnd();
        und.eingaenge[0] = new Eingang(false);
        und.eingaenge[1] = new Eingang(true);

        BinaeresGatter oder = new BinaeresGatterOder();
        oder.eingaenge[0] = und;
        oder.eingaenge[1] = new Eingang(true);

        GatterNicht nicht = new GatterNicht();
        nicht.eingang = oder;

        return testString("(NICHT ((FALSCH UND WAHR) ODER WAHR))", nicht.toString())
                && testBoolean(false, nicht.getOutput());
    }

}