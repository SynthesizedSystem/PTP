package org.aufgabe6;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a board game with a title, a range of players, and a minimum age requirement.
 */
public class Brettspiel {
    private final String titel;
    private final int[] spielerAnzahl = new int[2];
    private final int mindestAlter;

    /**
     * Constructs a new Brettspiel instance.
     *
     * @param titel         the title of the board game
     * @param spielerAnzahl an array with two elements, representing the minimum and maximum number of players
     * @param mindestAlter  the minimum age required to play the game
     */
    Brettspiel(String titel, int[] spielerAnzahl, int mindestAlter) {
        this.titel = titel;
        this.spielerAnzahl[0] = spielerAnzahl[0];
        this.spielerAnzahl[1] = spielerAnzahl[1];
        this.mindestAlter = mindestAlter;
    }

    /**
     * Gets the minimum age required to play the game.
     *
     * @return the minimum age
     */
    public int getMindestAlter() {
        return mindestAlter;
    }

    /**
     * Gets the range of players for the game.
     *
     * @return an array with two elements: the minimum and maximum number of players
     */
    public int[] getSpielerAnzahl() {
        return spielerAnzahl;
    }

    /**
     * Gets the title of the game.
     *
     * @return the title of the game
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Returns a string representation of the game, including its title, player range, and minimum age.
     *
     * @return a string representation of the game
     */
    @Override
    public String toString() {
        return String.format("%s (%d-%d Spieler:innen, ab %d Jahren)", titel, spielerAnzahl[0], spielerAnzahl[1], mindestAlter);
    }

    /**
     * Compares this game to the specified object for equality.
     *
     * @param o the object to compare with
     * @return true if the specified object is equal to this game, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brettspiel that = (Brettspiel) o;
        return getMindestAlter() == that.getMindestAlter()
                && Objects.equals(getTitel(), that.getTitel())
                && Objects.deepEquals(getSpielerAnzahl(), that.getSpielerAnzahl());
    }

    /**
     * Returns a hash code value for the game.
     *
     * @return a hash code value for the game
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTitel(), Arrays.hashCode(getSpielerAnzahl()), getMindestAlter());
    }

    /**
     * Prints the string representation of the game to the standard output.
     */
    public void ausgeben() {
        System.out.println(this.toString());
    }
}
