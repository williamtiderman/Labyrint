package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		
		int n = 20;
		
		//MazeGeneration maze = new MazeGenSideWind(n);
		MazeGeneration maze = new MazeGenRecBack(n);
		
        StdDraw.enableDoubleBuffering();
       
        //MazeSolveOne mazeSolver = new MazeSolveOne(maze);
        MazeSolveTwo2nd mazeSolver = new MazeSolveTwo2nd(maze);
        
        mazeSolver.solve();
        
	}

}
