package mazeGeneration;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner choose = new Scanner(System.in);
		System.out.println("Vilken labyrint generator vill du ha? "
				+ "Rekursiv eller Sidewind, y för Rekursiv och n för Sidewind");
		String yesNo = choose.nextLine();
		int n = 20;
		while(choose.hasNext()) {
			if(yesNo.equals("y")) {
				MazeGeneration maze = new MazeGenRecBack(n);
				StdDraw.enableDoubleBuffering();
				MazeSolveDepthFirst mazeSolver = new MazeSolveDepthFirst(maze);
				mazeSolver.solve();
			}
			else if(yesNo.equals("n")) {
				MazeGeneration maze = new MazeGenRecBack(n);
				MazeSolveLoop mazeSolver = new MazeSolveLoop(maze);
				mazeSolver.solve();
			}
			else if(!yesNo.equals("y") || !yesNo.equals("n")){
				System.out.println("Fel inmatning av val");
			}    
		}
	}

}
