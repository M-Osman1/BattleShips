//import java.io.*;
import java.util.*;
public class BattleShips {
	
	private char[][] grid;
	
	public BattleShips(int x, int y) {
		grid = new char[x][y];
	}
	
	public void print() {
		System.out.println("     0  1  2  3  4  5  6  7  8  9");
		for (int i = 0; i < grid.length; i++) {
			System.out.print(i +"   ");
			for (int k = 0; k < grid[i].length; k++) {
				if (grid[i][k] != 'M' && grid[i][k] != 'H')
					System.out.print("[" + " " + "]");
				else
					System.out.print("[" + grid[i][k] + "]");
	        }
	        System.out.println();
	      }
	}
	public void current() {
		System.out.println("     0  1  2  3  4  5  6  7  8  9");
		for (int i = 0; i < grid.length; i++) {
			System.out.print(i +"   ");
			for (int k = 0; k < grid[i].length; k++) {
				if (grid[i][k] != 'S')
					System.out.print("[" + " " + "]");
				else
					System.out.print("[" + grid[i][k] + "]");
	        }
	        System.out.println();
	      }
	}

	public void placeShips() {
		//Place submarine (3 squares) 
		for (int i = 0; i < 1; i++) { 
			System.out.println("Submarine 1");
			Random random = new Random(); 
			int randomInt = random.nextInt(10); 
			int randomInt2 = random.nextInt(10);
			boolean canPlace = false;
			//System.out.println(randomInt);
			//System.out.println(randomInt2);
			if (randomInt2 < 8) { 
				for (int x = randomInt2; x < randomInt2 + 3; x++) {
					if (grid[randomInt][x] != 'S')
							canPlace = true;
					else {
						i--;
						break;
					}
				} 
			} else
				i--;
			if (randomInt2 < 8) {
				if (canPlace == true) {
					for (int x = 0; x < 3; x++) {
						grid[randomInt][randomInt2] = 'S';
						randomInt2++;
					}
				}
			}
						 
		}
		//Place all 4 other ships 
		int length = 5;
		while (length > 1) {
			//System.out.println("SHIP " + length);
			for (int i = 0; i < 1; i++) {
				boolean canPlace = false;
				Random random = new Random();   
				int randomInt = random.nextInt(10);
				int randomInt2 = random.nextInt(10);
				//System.out.println(randomInt);
				//System.out.println(randomInt2);
				if (randomInt2 < 10 - length + 1) {
					if (grid[randomInt][randomInt2] != 'S') {
						for (int x = randomInt2; x < randomInt2 + length; x++) {
							if (grid[randomInt][x] != 'S')
								canPlace = true;
							else {
								i--;
							}
						}
					}
					else
						i--;
				} else
					i--;
				if (randomInt2 < 10 - length + 1) {
					if (canPlace == true) {
						for (int x = 0; x < length; x++) {
							grid[randomInt][randomInt2] = 'S';
							randomInt2++;
						}
					}
				}
			}
			length--;
		}	
		 
	}
	public boolean canFire(int row, int col) {
		if (grid[row][col] != 'M' && grid[row][col] != 'H')
			return true;
		else
			return false;
		
	}
	public void processFire(int row, int col) {
		if (canFire(row,col)) {
			if (grid[row][col] == 'S') 
				grid[row][col] = 'H';
			else
				grid[row][col] = 'M';
		}
		
	}
	public boolean gameOver() {
		int hitCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int k = 0; k < grid[i].length; k++) {
				if (grid[i][k] == 'H')
					hitCount++;
				if (hitCount == 17) {
               System.out.println("Well Done! you havee hit all the ships");
					return true;
				}
	        }
	      }		
		return false;
		
	}
}
