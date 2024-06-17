package aufgabe4;

public class Wagen {
    static int assign_id = 0;
    public static void flushId() {
        assign_id = 0;
    }

    public Wagen next = null;
    public int id = 0;

    public Wagen() {
        this.id = assign_id++;
    }

    public boolean vergleichen(Wagen wagen) {
        return this.id == wagen.id;
    }

    public String toString() {
        return id + "->";
    }
}
