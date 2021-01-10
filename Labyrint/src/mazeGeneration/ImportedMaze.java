package mazeGeneration;

import java.util.List;



public class ImportedMaze implements MazeGeneration {

	private int n;                 // dimension of maze
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private List<List<Boolean>> visited;

	public ImportedMaze(List<List<Boolean>> north,List<List<Boolean>> east,List<List<Boolean>> south,List<List<Boolean>> west,List<List<Boolean>> visited, int n) {
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
		this.visited = visited;
		this.n = n;


	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<List<Boolean>> getNorth() {
		// TODO Auto-generated method stub
		return this.north;
	}

	@Override
	public List<List<Boolean>> getEast() {
		// TODO Auto-generated method stub
		return this.east;
	}

	@Override
	public List<List<Boolean>> getWest() {
		// TODO Auto-generated method stub
		return this.west;
	}

	@Override
	public List<List<Boolean>> getSouth() {
		// TODO Auto-generated method stub
		return this.south;
	}

	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return this.n;
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void generate(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<List<Boolean>> getVisited() {
		// TODO Auto-generated method stub
		return this.visited;
	}

}
