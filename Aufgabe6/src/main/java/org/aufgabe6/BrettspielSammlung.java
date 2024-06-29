package org.aufgabe6;

import java.util.Arrays;

/**
 * Represents a collection of board games.
 */
public class BrettspielSammlung {
    private Brettspiel[] brettspielen = new Brettspiel[1];
    private int anzahlBrettspiele = 0;

    /**
     * Returns the index of the specified board game in the collection.
     *
     * @param bs the board game to find
     * @return the index of the board game, or -1 if it is not found
     */
    public int getIndexFuer(Brettspiel bs) {
        for (int i = 0; i < brettspielen.length; i++) {
            if (bs.equals(brettspielen[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the number of board games in the collection.
     *
     * @return the number of board games
     */
    public int getAnzahlBrettspiele() {
        return anzahlBrettspiele;
    }

    /**
     * Returns the board game at the specified index.
     *
     * @param index the index of the board game
     * @return the board game at the specified index
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     */
    public Brettspiel getBrettspielAnIndex(int index) {
        return brettspielen[index];
    }

    /**
     * Adds a new board game to the collection.
     *
     * @param bs the board game to add
     * @throws IllegalArgumentException if the board game is null
     */
    void hinzufuegen(Brettspiel bs) {
        if (bs == null) {
            throw new IllegalArgumentException();
        }
        if (anzahlBrettspiele >= brettspielen.length) {
            brettspielen = Arrays.copyOf(brettspielen, 2 * brettspielen.length);
        }
        brettspielen[anzahlBrettspiele++] = bs;
    }

    /**
     * Removes a board game from the collection.
     *
     * @param bs the board game to remove
     */
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

    /**
     * Returns a string representation of the collection, including the number of board games and their details.
     *
     * @return a string representation of the collection
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("%d Brettspiele\n", anzahlBrettspiele));
        for (Brettspiel bs : brettspielen) {
            if (bs != null) {
                ret.append(bs.toString()).append('\n');
            }
        }
        return ret.toString();
    }

    /**
     * Clears the collection of all board games.
     */
    void leeren() {
        brettspielen = new Brettspiel[brettspielen.length];
        anzahlBrettspiele = 0;
    }
}
