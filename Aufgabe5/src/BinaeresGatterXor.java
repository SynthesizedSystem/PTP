/**
 * Class representing a binary XOR gate, extending the BinaeresGatter class.
 */
public class BinaeresGatterXor extends BinaeresGatter {

    /**
     * Retrieves the output state of the XOR gate.
     * This method performs an XOR operation on the outputs of the two input gates.
     *
     * @return the result of the XOR operation between the two input gates' outputs.
     * @throws NullPointerException if the inputs are not properly set.
     */
    @Override
    public boolean getOutput() {
        AssertEingaenge();
        return eingaenge[0].getOutput() ^ eingaenge[1].getOutput();
    }

    /**
     * Provides a string representation of the XOR gate.
     * The string representation includes the type of gate and its inputs.
     *
     * @return a string representation of the XOR gate and its input gates.
     * @throws NullPointerException if the inputs are not properly set.
     */
    @Override
    public String toString() {
        AssertEingaenge();
        return String.format("(%s XOR %s)", eingaenge[0].toString(), eingaenge[1].toString());
    }
}
