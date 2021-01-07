package mazeGeneration;

import java.util.Stack;

public class MazeGenRecBack implements MazeGeneration {

	private int n;                 // dimension of maze
    private boolean[][] north;     // is there a wall to north of cell i, j
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private boolean done = false;
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean[][] getNorth() {
		// TODO Auto-generated method stub
		return this.north;
	}

	@Override
	public boolean[][] getEast() {
		// TODO Auto-generated method stub
		return this.east;
	}

	@Override
	public boolean[][] getWest() {
		// TODO Auto-generated method stub
		return this.west;
	}

	@Override
	public boolean[][] getSouth() {
		// TODO Auto-generated method stub
		return this.south;
	}//a

	@Override
	public boolean[][] getVisited() {
		return this.visited;
	}

	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public void generate() {
		generate(1,1);
		
	}
	
	@Override
	public void generate(int x, int y) {
		Stack<mazeNode> mazeStack = new Stack<mazeNode>;
		
		
	}
	

}
