package strategies;

import aufgabe4.Train;
import aufgabe4.Wagon;

public class AttachIterative implements AttachStrategy {

    @Override
    public void attach(Train train, Wagon wagon) {
        if (train.first == null) {
            train.first = wagon;
            return;
        }

        Wagon currentWagon = train.first;
        while (currentWagon.next != null) {
            currentWagon = currentWagon.next;
        }

        if (currentWagon != wagon) {
            currentWagon.next = wagon;
        } else {
            throw new IllegalArgumentException("You cannot attach wagon to itself");
        }
    }
}
}
