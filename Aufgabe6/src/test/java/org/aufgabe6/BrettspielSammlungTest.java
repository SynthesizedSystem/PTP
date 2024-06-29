package org.aufgabe6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BrettspielSammlungTest {
    @Test
    public void testBrettspielSammlungHinzufuegen() {
        Brettspiel bs = new Brettspiel("Gloomhaven", new int[]{1, 4}, 12);
        BrettspielSammlung bss = new BrettspielSammlung();
        bss.hinzufuegen(bs);

        Assertions.assertEquals(bs, bss.getBrettspielAnIndex(0));
        Assertions.assertEquals(1, bss.getAnzahlBrettspiele());
        Assertions.assertEquals(0, bss.getIndexFuer(bs));
    }

    @Test
    public void testBrettspielSammlungHinzufuegenNull() {
        BrettspielSammlung bss = new BrettspielSammlung();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                bss.hinzufuegen(null));
    }

    @Test
    public void testBrettspielSammlungEntfernen() {
        Brettspiel bs = new Brettspiel("Gloomhaven", new int[]{1, 4}, 12);
        BrettspielSammlung bss = new BrettspielSammlung();
        bss.hinzufuegen(bs);
        bss.entfernen(bs);

        Assertions.assertNull(bss.getBrettspielAnIndex(0));
        Assertions.assertEquals(0, bss.getAnzahlBrettspiele());
        Assertions.assertEquals(-1, bss.getIndexFuer(bs));
    }

    @Test
    public void testBrettspielSammlungEntfernenNichts() {
        Brettspiel bs1 = new Brettspiel("Gloomhaven1", new int[]{1, 4}, 12);
        Brettspiel bs2 = new Brettspiel("Gloomhaven2", new int[]{1, 4}, 12);
        BrettspielSammlung bss = new BrettspielSammlung();
        bss.hinzufuegen(bs1);
        bss.entfernen(bs2);

        Assertions.assertEquals(bs1, bss.getBrettspielAnIndex(0));
        Assertions.assertEquals(1, bss.getAnzahlBrettspiele());
        Assertions.assertEquals(0, bss.getIndexFuer(bs1));
    }

    @Test
    public void testBrettspielSammlungLeeren() {
        Brettspiel bs1 = new Brettspiel("Gloomhaven1", new int[]{1, 4}, 12);
        Brettspiel bs2 = new Brettspiel("Gloomhaven2", new int[]{1, 4}, 12);
        BrettspielSammlung bss = new BrettspielSammlung();
        bss.hinzufuegen(bs1);
        bss.hinzufuegen(bs2);
        bss.leeren();

        Assertions.assertEquals(0, bss.getAnzahlBrettspiele());
        Assertions.assertEquals(-1, bss.getIndexFuer(bs1));
        Assertions.assertEquals(-1, bss.getIndexFuer(bs2));
    }
}
