/**
 * Class representing a binary AND gate, extending the BinaeresGatter class.
 */
public class BinaeresGatterUnd extends BinaeresGatter {

    /**
     * Retrieves the output state of the AND gate.
     * This method performs an AND operation on the outputs of the two input gates.
     *
     * @return the result of the AND operation between the two input gates' outputs.
     * @throws NullPointerException if the inputs are not properly set.
     */
    @Override
    public boolean getOutput() {
        AssertEingaenge();
        return eingaenge[0].getOutput() && eingaenge[1].getOutput();
    }

    /**
     * Provides a string representation of the AND gate.
     * The string representation includes the type of gate and its inputs.
     *
     * @return a string representation of the AND gate and its input gates.
     * @throws NullPointerException if the inputs are not properly set.
     */
    @Override
    public String toString() {
        AssertEingaenge();
        return String.format("(%s UND %s)", eingaenge[0].toString(), eingaenge[1].toString());
    }
}
