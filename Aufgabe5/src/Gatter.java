/**
 * Interface defining the contract for a logical gate.
 */
public interface Gatter {
    /**
     * Retrieves the output state of the gate.
     *
     * @return the output state of the gate as a boolean.
     */
    boolean getOutput();

    /**
     * Provides a string representation of the gate.
     *
     * @return a string representation of the gate.
     */
    @Override
    String toString();
}
