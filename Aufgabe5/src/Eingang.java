/**
 * Class representing an input gate that implements the Gatter interface.
 * This gate has a fixed boolean value.
 */
public class Eingang implements Gatter {
    /**
     * The fixed boolean value of this input gate.
     */
    private final boolean wert;

    /**
     * Constructs an Eingang with a specified boolean value.
     *
     * @param wert the boolean value to set for this input gate.
     */
    Eingang(boolean wert) {
        this.wert = wert;
    }

    /**
     * Retrieves the output state of the input gate.
     * This method returns the fixed boolean value of this gate.
     *
     * @return the boolean value of this input gate.
     */
    @Override
    public boolean getOutput() {
        return wert;
    }

    /**
     * Provides a string representation of the input gate.
     * The string representation is "WAHR" if the value is true, and "FALSCH" if the value is false.
     *
     * @return a string representation of the input gate's value.
     */
    @Override
    public String toString() {
        return wert ? "WAHR" : "FALSCH";
    }
}
