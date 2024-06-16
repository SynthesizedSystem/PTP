public class Eingang implements Gatter {
    private final boolean wert;

    Eingang(boolean wert) {
        this.wert = wert;
    }

    @Override
    public boolean getOutput() {
        return wert;
    }

    @Override
    public String toString() {
        return wert ? "WAHR" : "FALSCH";
    }
}
