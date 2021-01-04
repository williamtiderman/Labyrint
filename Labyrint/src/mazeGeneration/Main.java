package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 20;
        MazeGeneration maze = new MazeGenOne(n);
        StdDraw.enableDoubleBuffering();
        maze.draw();
        MazeSolveOne mazeSolver = new MazeSolveOne(maze);
        
        mazeSolver.solve();
	}

}
