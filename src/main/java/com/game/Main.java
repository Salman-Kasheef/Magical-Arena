package com.game;

public class Main {
    public static void main(String[] args) {
       Player playerA = new Player("Player A",50,5,10);
       Player playerB = new Player("Player B",100,10,5);

        System.out.println("Starting the fight between " + playerA.getName() + " and " + playerB.getName());

        Arena arena = new Arena(playerA, playerB);
        arena.fight();

        Player winner = arena.getWinner();
        if (winner != null){
            System.out.println("The winner is: " + winner.getName());
        } else {
            System.out.println("It's a draw!");
        }

    }
}