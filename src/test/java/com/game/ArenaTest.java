package com.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArenaTest {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        player1 = new Player("Player A", 50, 5, 10);
        player2 = new Player("Player B", 100, 10, 5);
    }

    @Test
    public void testFight() {
        Arena arena = new Arena(player1, player2);
        arena.fight();

        Player winner = arena.getWinner();
        assertNotNull(winner);
        assertTrue(winner.getHealth() > 0);
    }

    @Test
    public void testPlayer1Wins() {
        Player strongPlayer = new Player("Strong Player", 50, 20, 50);
        Player weakPlayer = new Player("Weak Player", 10, 1, 1);

        Arena arena = new Arena(strongPlayer, weakPlayer);
        arena.fight();

        assertEquals(strongPlayer, arena.getWinner());
    }

    @Test
    public void testPlayer2Wins() {
        Player weakPlayer = new Player("Weak Player", 10, 1, 1);
        Player strongPlayer = new Player("Strong Player", 50, 20, 50);

        Arena arena = new Arena(weakPlayer, strongPlayer);
        arena.fight();

        assertEquals(strongPlayer, arena.getWinner());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPlayerCreation() {
        new Player("Invalid Player", -10, 5, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDamage() {
        Player player = new Player("Player", 50, 5, 10);
        player.reduceHealth(-10);
    }
}
