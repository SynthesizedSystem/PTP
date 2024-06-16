public class BinaeresGatterOder extends BinaeresGatter {
    @Override
    public boolean getOutput() {
        AssertEingaenge();
        return eingaenge[0].getOutput() || eingaenge[1].getOutput();
    }

    @Override
    public String toString() {
        AssertEingaenge();
        return String.format("(%s ODER %s)", eingaenge[0].toString(), eingaenge[1].toString());
    }
}
