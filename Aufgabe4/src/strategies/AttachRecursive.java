package strategies;

import aufgabe4.Zug;
import aufgabe4.Wagen;

public class AttachRecursive implements AttachStrategy {
    @Override
    public void attach(Zug train, Wagen wagon) {
        if (train.first == null) {
            train.first = wagon;
            return;
        }
        recursiveAttach(train.first, wagon);
    }

    private void recursiveAttach(Wagen currentWagon, Wagen wagon) {
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
