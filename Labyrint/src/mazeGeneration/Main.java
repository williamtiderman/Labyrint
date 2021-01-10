package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		
		int n = 36;
		
		//MazeGeneration maze = new MazeGenSideWind(n);
		MazeGeneration maze2 = new MazeGenRecBack(n);
		
        StdDraw.enableDoubleBuffering();
       
        //MazeSolveOne mazeSolver = new MazeSolveOne(maze);
        MazeSolveOne mazeSolver2 = new MazeSolveOne(maze2);
        
        mazeSolver2.solve();
        //mazeSolver.solve();
	}

}
