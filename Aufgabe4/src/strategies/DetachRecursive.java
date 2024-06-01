package strategies;

import aufgabe4.Train;
import aufgabe4.Wagon;

public class DetachRecursive implements DetachStrategy {
    @Override
    public boolean detach(Train train, Wagon wagon) {
        return true;
    }
}
