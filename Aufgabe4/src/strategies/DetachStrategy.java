package strategies;

import aufgabe4.Zug;
import aufgabe4.Wagen;

public interface DetachStrategy {
    public boolean detach(Zug train, Wagen wagon);
}
