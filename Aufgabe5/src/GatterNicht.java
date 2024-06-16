public class GatterNicht implements Gatter {
    public Gatter eingang;

    @Override
    public boolean getOutput() {
        if (eingang == null) {
            throw new NullPointerException("eingang ist nicht gefunden");
        }
        return !eingang.getOutput();
    }

    @Override
    public String toString() {
        return String.format("(NICHT %s)", eingang.toString());
    }
}
