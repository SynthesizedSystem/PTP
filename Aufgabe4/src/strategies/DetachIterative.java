package strategies;

import aufgabe4.Zug;
import aufgabe4.Wagen;

public class DetachIterative implements DetachStrategy {
    @Override
    public boolean detach(Zug train, Wagen wagon) {
        if (train.first == null) {
            return false; // Train is empty
        }

        if (train.first.id == wagon.id) {
            // Detach wagon and make sure detached wagon points again to null reference
            Wagen detachedWagon = train.first;
            train.first = train.first.next;
            detachedWagon.next = null;
            return true; // First wagon satisfies condition
        }

        Wagen currentWagon = train.first;
        while (currentWagon.next != null) {
            if (currentWagon.next.id == wagon.id) {
                Wagen detachedWagon = currentWagon.next;
                currentWagon.next = currentWagon.next.next;
                detachedWagon.next = null;
                return true;
            }
            currentWagon = currentWagon.next;
        }
        return false;
    }
}
