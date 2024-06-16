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
            // Make sure we are not attaching wagon to itself
            if (currentWagon != wagon) {
                currentWagon.next = wagon;
            } else {
                throw new IllegalArgumentException("You cannot attach wagon to itself");
            }
            return;
        }
        recursiveAttach(currentWagon.next, wagon);
    }
}
