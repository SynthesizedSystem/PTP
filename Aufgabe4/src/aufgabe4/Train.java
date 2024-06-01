package aufgabe4;

import strategies.AttachStrategy;
import strategies.AttachIterative;
import strategies.DetachIterative;
import strategies.DetachStrategy;

public class Train {
    public Wagon first = null;
    // Iterative is default strategy, but could be set to recursive
    private AttachStrategy attachStrategy = new AttachIterative();
    private DetachStrategy detachStrategy = new DetachIterative();

    public Train() {
    }

    public Train(AttachStrategy attachStrategy, DetachStrategy detachStrategy) {
        this.attachStrategy = attachStrategy;
        this.detachStrategy = detachStrategy;
    }

    public void attachWagon(Wagon wagon) {
        attachStrategy.attach(this, wagon);
    }

    public void detachWagon(Wagon wagon) {
        detachStrategy.detach(this, wagon);
    }

    public void setAttachStrategy(AttachStrategy strategy) {
        attachStrategy = strategy;
    }

    public void setDetachStrategy(DetachStrategy strategy) {
        detachStrategy = strategy;
    }

    public String toString() {
        StringBuilder trainString = new StringBuilder();
        trainString.append("Train: ");

        Wagon currentWagon = first;
        while (currentWagon != null) {
            trainString.append(currentWagon.toString());
            currentWagon = currentWagon.next;
        }
        return trainString.toString();
    }
}
