package mazeGeneration;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner choose = new Scanner(System.in);
		System.out.println("Vilken labyrint generator vill du ha? "
				+ "Rekursiv eller Sidewind, R för Rekursiv och S för Sidewind");
		String yesNo = choose.nextLine();
		System.out.println("Hur stor ska labyrinten vara(Skriv en sida för kvadranten)");
		String size = choose.nextLine();
		
		MazeGeneration maze = null;
		MazeSolver mazeSolver = null;
		
		
		int n = 15;
		try {
			n = Integer.parseInt(size);
		} catch (NumberFormatException e) {
			System.out.println("Inte ett nummer");
			e.printStackTrace();
		}
		
		if(yesNo.equalsIgnoreCase("R")) {
			maze = new MazeGenRecBack(n);
			StdDraw.enableDoubleBuffering();
		}
		else if(yesNo.equalsIgnoreCase("S")) {
			maze = new MazeGenSideWind(n);
			StdDraw.enableDoubleBuffering();
		}
		else if(!yesNo.equalsIgnoreCase("r") || !yesNo.equalsIgnoreCase("s")){
			System.out.println("Fel inmatning av val");
		}
		
		System.out.println("Labyrint klar, ska den lösas eller printas till textfil (L eller P)?");
		String solveOrPrint = choose.nextLine();
		
		if(solveOrPrint.equalsIgnoreCase("L")) {
			System.out.println("Vad för algoritm, depth-first eller stack loop (D eller S)?");
			String solve = choose.nextLine();
			
			if(solve.equalsIgnoreCase("D")) {
				mazeSolver = new MazeSolveDepthFirst(maze);
			}
			if(solve.equalsIgnoreCase("S")) {
				mazeSolver = new MazeSolveLoop(maze);
			}
			mazeSolver.solve();
			
		}
		else if(solveOrPrint.equalsIgnoreCase("P")) {
			MazeExport export = new MazeExport(maze);
			System.out.println("Print klar");
		}
		else if(!solveOrPrint.equalsIgnoreCase("P") || !solveOrPrint.equalsIgnoreCase("L")){
			System.out.println("Fel inmatning av val");
		}
		

		choose.close();
	}

}
