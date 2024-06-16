public abstract class BinaeresGatter implements Gatter {
    public final Gatter[] eingaenge = new Gatter[2];

    @Override
    public abstract boolean getOutput();

    public void AssertEingaenge() {
        if (eingaenge[0] == null || eingaenge[1] == null) {
            throw new NullPointerException("eingaenge sind nicht gefunden");
        }
    }
}
