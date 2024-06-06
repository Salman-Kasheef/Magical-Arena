package com.game;

public class Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;

    public Player(String name, int health, int strength, int attack) {
        if(health <= 0 || strength <= 0 || attack <= 0){
            throw new IllegalArgumentException("Health, strength, and attack values must be positive integers.");
        }
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public void reduceHealth(int amount){
        if (amount < 0){
            throw new IllegalArgumentException("Damage amount must be a positive integer.");
        }
        this.health = Math.max(this.health - amount, 0);
    }
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return name + "{" +
                 "health=" + health +
                ", strength=" + strength +
                ", attack=" + attack +
                '}';
    }
}
