package org.aufgabe6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BrettspielTest {
    @Test
    public void testBrettspiel() {
        Brettspiel bs = new Brettspiel("Gloomhaven", new int[]{1, 4}, 12);
        Assertions.assertEquals("Gloomhaven", bs.getTitel());
        Assertions.assertArrayEquals(new int[] {1, 4}, bs.getSpielerAnzahl());
        Assertions.assertEquals(12, bs.getMindestAlter());
    }
}
