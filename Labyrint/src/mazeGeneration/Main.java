package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
        //MazeGeneration maze = new MazeGenOne(n);
		MazeGenRecBack maze = new MazeGenRecBack(n);
        StdDraw.enableDoubleBuffering();
        maze.draw();
        System.out.println("Wtf Men bra");
        //MazeSolveOne mazeSolver = new MazeSolveOne(maze);
        
        //mazeSolver.solve();
	}

}
