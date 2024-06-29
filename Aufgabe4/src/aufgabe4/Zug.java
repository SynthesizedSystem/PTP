package aufgabe4;

import strategies.AttachStrategy;
import strategies.AttachIterative;
import strategies.DetachIterative;
import strategies.DetachStrategy;

import java.util.ArrayList;

public class Zug {
    public Wagen first = null;
    // Iterative is default strategy, but could be set to recursive
    private AttachStrategy attachStrategy = new AttachIterative();
    private DetachStrategy detachStrategy = new DetachIterative();

    public Zug() {
    }

    public Zug(AttachStrategy attachStrategy, DetachStrategy detachStrategy) {
        this.attachStrategy = attachStrategy;
        this.detachStrategy = detachStrategy;
    }

    public void anhaengen(Wagen wagon) {
        attachStrategy.attach(this, wagon);
    }

    public void abhaengen(Wagen wagon) {
        detachStrategy.detach(this, wagon);
    }

    public void setAttachStrategy(AttachStrategy strategy) {
        attachStrategy = strategy;
    }

    public void setDetachStrategy(DetachStrategy strategy) {
        detachStrategy = strategy;
    }

    public boolean vergleichen(Zug zug) {
        Wagen thisTrainWagon = this.first;
        while (thisTrainWagon != null) {
            Wagen otherTrainWagon = zug.first;
            while (otherTrainWagon != null) {
                if (thisTrainWagon.vergleichen(otherTrainWagon))
                    return true;
                otherTrainWagon = otherTrainWagon.next;
            }
            thisTrainWagon = thisTrainWagon.next;
        }
        return false;
    }

    public String toString() {
        StringBuilder trainString = new StringBuilder();
        trainString.append("Train: ");

        Wagen currentWagon = first;
        while (currentWagon != null) {
            trainString.append(currentWagon.toString());
            currentWagon = currentWagon.next;
        }
        return trainString.toString();
    }
}
