package strategies;

import aufgabe4.Train;
import aufgabe4.Wagon;

public interface DetachStrategy {
    public boolean detach(Train train, Wagon wagon);
}
