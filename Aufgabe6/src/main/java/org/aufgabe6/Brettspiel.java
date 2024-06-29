package org.aufgabe6;

import java.util.Arrays;
import java.util.Objects;

public class Brettspiel {
    private final String titel;
    private final int[] spielerAnzahl = new int[2];
    private final int mindestAlter;

    Brettspiel(String titel, int[] spielerAnzahl, int mindestAlter) {
        this.titel = titel;
        this.spielerAnzahl[0] = spielerAnzahl[0];
        this.spielerAnzahl[1] = spielerAnzahl[1];
        this.mindestAlter = mindestAlter;
    }

    public int getMindestAlter() {
        return mindestAlter;
    }

    public int[] getSpielerAnzahl() {
        return spielerAnzahl;
    }

    public String getTitel() {
        return titel;
    }

    @Override
    public String toString() {
        return String.format("%s (%d-%d Spieler:innen, ab %d Jahren)", titel, spielerAnzahl[0], spielerAnzahl[1], mindestAlter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brettspiel that = (Brettspiel) o;
        return getMindestAlter() == that.getMindestAlter()
                && Objects.equals(getTitel(), that.getTitel())
                && Objects.deepEquals(getSpielerAnzahl(), that.getSpielerAnzahl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitel(), Arrays.hashCode(getSpielerAnzahl()), getMindestAlter());
    }

    public void ausgeben() {
        System.out.println(this.toString());
    }

}
