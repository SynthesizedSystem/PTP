package aufgabe4;

public class Wagon {
    static int assign_id = 0;
    public static void flushId() {
        assign_id = 0;
    }

    public Wagon next = null;
    public int id = 0;

    public Wagon() {
        this.id = assign_id++;
    }

    public String toString() {
        return id + "->";
    }
}
