package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 16;
        //MazeGeneration maze = new MazeGenOne(n);
		
		MazeGeneration maze = new MazeGenRecDiv(n);
		//MazeGeneration maze = new MazeGenRecBack(n);
		
		//MazeGenOne maze = new MazeGenOne(n);
		
        StdDraw.enableDoubleBuffering();
        //maze.draw();
       
        //MazeSolveOne mazeSolver = new MazeSolveOne(maze);
        
        //mazeSolver.solve();
	}

}
