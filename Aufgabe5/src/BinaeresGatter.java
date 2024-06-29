/**
 * Abstract class representing a binary gate, implementing the Gatter interface.
 * This class provides common functionality for binary gates, such as storing
 * input gates and checking their validity.
 */
public abstract class BinaeresGatter implements Gatter {
    /**
     * The input gates for this binary gate.
     * This array should contain exactly two input gates.
     */
    public final Gatter[] eingaenge = new Gatter[2];

    /**
     * Retrieves the output state of the binary gate.
     * This method must be implemented by subclasses to define the specific
     * behavior of the binary gate (e.g., AND, OR, XOR).
     *
     * @return the output state of the binary gate.
     */
    @Override
    public abstract boolean getOutput();

    /**
     * Asserts that both input gates are properly set.
     * This method checks if both input gates are non-null and throws a
     * NullPointerException if either input gate is not set.
     *
     * @throws NullPointerException if either of the input gates is not set.
     */
    public void AssertEingaenge() {
        if (eingaenge[0] == null || eingaenge[1] == null) {
            throw new NullPointerException("eingaenge sind nicht gefunden");
        }
    }
}
