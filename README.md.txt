# Magical Arena

This project implements a magical arena where two players can fight until one of them loses all their health. 

## How to Run

To run the game, compile the Java files and run the `Main` class.


```bash
javac -d out src/main/java/com/game/*.java
java -cp out com.game.Main


## Unit Tests

To run the unit tests, execute the test classes using a test runner like JUnit.

## Project Structure

- `src/main/java/com/game/Player.java` - Player class representing a player in the arena.
- `src/main/java/com/game/Arena.java` - Arena class that manages the fight between players.
- `src/test/java/com/game/PlayerTest.java` - Unit tests for the Player class.
- `src/test/java/com/game/ArenaTest.java` - Unit tests for the Arena class.
