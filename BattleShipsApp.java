import java.util.Scanner;
public class BattleShipsApp {
	public static void main(String[] args) {
		
		BattleShips app = new BattleShips(10,10);
		System.out.println("        Welcome to BattleShips");
		app.placeShips();
		app.current();
		Scanner sc = new Scanner(System.in);
        
		while (app.gameOver() == false) {
			app.print();
            System.out.println("What row and column do you want to fire on?");
            System.out.print("row 0-9? ");
            int row = sc.nextInt();
            System.out.print("col 0-9? ");
            int col = sc.nextInt();
            app.processFire(row,col);
            System.out.println();
        }
		sc.close();
	}
}
