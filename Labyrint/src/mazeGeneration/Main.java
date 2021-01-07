package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 50;
        MazeGeneration maze = new MazeGenOne(n);
        StdDraw.enableDoubleBuffering();
        maze.draw();
        MazeSolveOne mazeSolver = new MazeSolveOne(maze);
        MazeSolveTwo2nd mazeSolver2 = new MazeSolveTwo2nd(maze);
        mazeSolver.solve();
        mazeSolver2.solve();
	}

}
