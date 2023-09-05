# Battleships Game

This is a simple implementation of the classic game "Battleships" in Java. In this game, you have a grid representing the ocean, and you need to guess the locations of hidden enemy ships and sink them by firing at the grid.

## How to Use

1. **Creating the Game**

   To start a new game, create an instance of the `BattleShips` class, specifying the grid dimensions (rows and columns) when you create an object.

   ```java
   BattleShips game = new BattleShips(rows, columns);
   ```

2. **Placing Ships**

   Before you start playing, the game automatically places the ships on the grid. There are five ships in total:
   - 1 Submarine (3 squares)
   - 4 Other Ships (with varying lengths)

   The placement of these ships is randomized.

3. **Viewing the Grid**

   You can view the current state of the grid using the `print()` method. This method will display the grid, showing your hits ('H'), misses ('M'), and empty spaces (' ') you haven't targeted yet.

   ```java
   game.print();
   ```

   You can also use the `current()` method to display the grid without revealing the hidden ships.

   ```java
   game.current();
   ```

4. **Firing**

   To make a guess and fire at a specific location on the grid, use the `processFire(row, col)` method, specifying the row and column you want to target. The game will mark the result as 'H' for a hit or 'M' for a miss.

   ```java
   int row = /* your target row */;
   int col = /* your target column */;
   game.processFire(row, col);
   ```

5. **Checking for Game Over**

   The game keeps track of your hits, and if you manage to hit all the ships (a total of 17 hits), it will declare you the winner and end the game.

   ```java
   if (game.gameOver()) {
       System.out.println("Well Done! You have hit all the ships.");
   }
   ```

## Example Usage

Here's an example of how you can use this Battleships game:

```java
public class Main {
    public static void main(String[] args) {
        // Create a Battleships game with a 10x10 grid
        BattleShips game = new BattleShips(10, 10);

        // Place ships on the grid
        game.placeShips();

        // Display the initial state of the grid
        System.out.println("Initial Grid:");
        game.current();

        // Play the game by making guesses and checking for a win
        while (!game.gameOver()) {
            // Get user input for row and column (replace with your input method)
            int row = /* user input */;
            int col = /* user input */;

            // Process the user's guess
            game.processFire(row, col);

            // Display the updated grid
            System.out.println("Updated Grid:");
            game.current();
        }

        System.out.println("Game Over!");
    }
}
```

Feel free to customize the example and integrate it into your own Java project. Enjoy playing Battleships!
