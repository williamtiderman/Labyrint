package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
        //MazeGeneration maze = new MazeGenOne(n);
		
		MazeGeneration maze = new MazeGenSideWind(n);
		//MazeGeneration maze = new MazeGenRecBack(n);
		System.out.println("Klar med Maze");
		//MazeGenOne maze = new MazeGenOne(n);
		
        StdDraw.enableDoubleBuffering();
        //maze.draw();
       
        MazeSolveOne mazeSolver = new MazeSolveOne(maze);
        
        mazeSolver.solve();
	}

}
