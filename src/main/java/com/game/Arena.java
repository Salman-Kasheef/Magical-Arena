package com.game;

import java.util.Random;

public class Arena {
    private final Player player1;
    private final Player player2;
    private final Random random;

    public Arena(Player player1, Player player2, Random random) {
        this.player1 = player1;
        this.player2 = player2;
        this.random = random;
    }

    public void fight(){
        Player attacker, defender;
        if (player1.getHealth() < player2.getHealth()){
            attacker = player1;
            defender = player2;
        } else {
            attacker = player2;
            defender = player1;
        }
    }
}
