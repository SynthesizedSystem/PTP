package org.aufgabe6;

import java.util.Arrays;

public class BrettspielSammlung {
    private Brettspiel[] brettspielen = new Brettspiel[1];
    private int anzahlBrettspiele = 0;

    public int getIndexFuer(Brettspiel bs) {
        for (int i = 0; i < brettspielen.length; i++) {
            if (bs.equals(brettspielen[i])) {
                return i;
            }
        }
        return -1;
    }

    public int getAnzahlBrettspiele() {
        return anzahlBrettspiele;
    }

    public Brettspiel getBrettspielAnIndex(int index) {
        return brettspielen[index];
    }

    void hinzufuegen(Brettspiel bs) {
        if (bs == null) {
            throw new IllegalArgumentException();
        }
        if (anzahlBrettspiele >= brettspielen.length) {
            brettspielen = Arrays.copyOf(brettspielen, 2 * brettspielen.length);
        }
        brettspielen[anzahlBrettspiele++] = bs;
    }

    void entfernen(Brettspiel bs) {
        int index = getIndexFuer(bs);
        if (index == -1) {
            return;
        }
        for (int i = index; i < anzahlBrettspiele - 1; i++) {
            brettspielen[i] = brettspielen[i + 1];
        }
        brettspielen[--anzahlBrettspiele] = null;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("%d Brettspielen\n", anzahlBrettspiele));
        for (Brettspiel bs : brettspielen) {
            if (bs != null) {
                ret.append(bs.toString()).append('\n');
            }
        };
        return ret.toString();
    }

    void leeren() {
        brettspielen = new Brettspiel[brettspielen.length];
        anzahlBrettspiele = 0;
    }
}
