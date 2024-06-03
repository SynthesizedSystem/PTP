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
            Wagon detachedWagon = train.first;
            train.first = train.first.next;
            detachedWagon.next = null;
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
