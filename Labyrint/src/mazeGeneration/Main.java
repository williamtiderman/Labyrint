package mazeGeneration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 100;
        MazeGenOne maze = new MazeGenOne(n);
        StdDraw.enableDoubleBuffering();
        maze.draw();
	}

}
