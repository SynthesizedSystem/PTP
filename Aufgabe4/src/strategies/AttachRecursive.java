package strategies;

import aufgabe4.Train;
import aufgabe4.Wagon;

public class AttachRecursive implements AttachStrategy {
    @Override
    public void attach(Train train, Wagon wagon) {
        if (train.first == null) {
            train.first = wagon;
            return;
        }
        recursiveAttach(train.first, wagon);
    }

    private void recursiveAttach(Wagon currentWagon, Wagon wagon) {
        if (currentWagon.next == null) {
            currentWagon.next = wagon;
            return;
        }
        recursiveAttach(currentWagon.next, wagon);
    }
}
