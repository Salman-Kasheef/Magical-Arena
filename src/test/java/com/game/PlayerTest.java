package com.game;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player("Player A", 50, 5, 10);

        assertEquals("Player A", player.getName());
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
    }

    @Test
    public void testReduceHealth() {
        Player player = new Player("Player A", 50, 5, 10);
        player.reduceHealth(40);

        assertEquals(10, player.getHealth());
        player.reduceHealth(15);
        assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHealth() {
        new Player("Player", 0, 5, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStrength() {
        new Player("Player", 50, 0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAttack() {
        new Player("Player", 50, 5, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReduceHealthNegativeAmount() {
        Player player = new Player("Player", 50, 5, 10);
        player.reduceHealth(-5);
    }
}
