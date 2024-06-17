package strategies;

import aufgabe4.Zug;
import aufgabe4.Wagen;

public interface AttachStrategy {
    public void attach(Zug train, Wagen wagon);
}
