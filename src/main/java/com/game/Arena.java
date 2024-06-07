package com.game;

import java.util.Random;

public class Arena {
    private final Player player1;
    private final Player player2;
    private final Random random;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.random = new Random();
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

        while (player1.getHealth() > 0 && player2.getHealth() > 0){
            performAttack(attacker, defender);
            if (defender.getHealth() <= 0)
                break;

            //Swap attacker and defender
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    private void performAttack(Player attacker, Player defender) {
        int attackRoll = rollDice();
        int defenseRoll = rollDice();

        int attackDamage = attackRoll * attacker.getAttack();
        int defense = defenseRoll * defender.getStrength();

        int damage = attackDamage - defense;
        if (damage > 0){
            int initialHealth = defender.getHealth();
            defender.reduceHealth(damage);
            System.out.println(attacker.getName() + " attacks! Rolls: " + attackRoll + " (Attack damage: " + attackRoll + " * " + attacker.getAttack() + " = " + attackDamage + ")");
            System.out.println(defender.getName() + " defends! Rolls: " + defenseRoll + "(Defense strength: " + defenseRoll + " * " + defender.getStrength() + " = " + defense + ")");
            System.out.println(defender.getName() + "'s health reduced from " + initialHealth + " to " + defender.getHealth() + " (Damage taken: " + damage + ")");
            System.out.println();
        } else {
            System.out.println(attacker.getName() + " attacks! Rolls: " + attackRoll + " (Attack damage: " + attackRoll + " * " + attacker.getAttack() + " = " + attackDamage + ")");
            System.out.println(defender.getName() + " defends! Rolls: " + defenseRoll + " (Defense strength: " + defenseRoll + " * " + defender.getStrength() + " = " + defense + ")");
            System.out.println(attacker.getName() + "'s attack was fully defended by " + defender.getName());
            System.out.println();
        }

    }

    private int rollDice(){
        return random.nextInt(6) + 1;
    }

    public Player getWinner(){
        if (player1.getHealth() <= 0){
            return player2;
        } else if (player2.getHealth() <= 0) {
            return player1;
        } else {
            return null; // no winner
        }
    }
}
