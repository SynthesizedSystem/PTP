/**
 * Class implementing the Gatter interface, representing a NOT gate.
 */
public class GatterNicht implements Gatter {
    /**
     * The input gate for this NOT gate.
     */
    public Gatter eingang;

    /**
     * Retrieves the output state of the NOT gate.
     * This method negates the output of the input gate.
     *
     * @return the negated output state of the input gate.
     * @throws NullPointerException if the input gate is not found (i.e., eingang is null).
     */
    @Override
    public boolean getOutput() {
        if (eingang == null) {
            throw new NullPointerException("eingang ist nicht gefunden");
        }
        return !eingang.getOutput();
    }

    /**
     * Provides a string representation of the NOT gate.
     * The string representation includes the type of gate and its input.
     *
     * @return a string representation of the NOT gate and its input gate.
     */
    @Override
    public String toString() {
        return String.format("(NICHT %s)", eingang.toString());
    }
}
