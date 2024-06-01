package strategies;

import aufgabe4.Train;
import aufgabe4.Wagon;

public class DetachIterative implements DetachStrategy {
    @Override
    public boolean detach(Train train, Wagon wagon) {
        if (train.first == null) {
            return false; // Train is empty
        }

        if (train.first.id == wagon.id) {
            train.first = train.first.next;
            return true; // First wagon satisfies condition
        }

        Wagon currentWagon = train.first;
        while (currentWagon.next != null) {
            if (currentWagon.next.id == wagon.id) {
                Wagon detachedWagon = currentWagon.next;
                currentWagon.next = currentWagon.next.next;
                detachedWagon.next = null;
                return true;
            }
            currentWagon = currentWagon.next;
        }
        return false;
    }
}
