package mazeGeneration;

public interface MazeGeneration {
	
	public void draw();
	public boolean[][] getNorth();
	public boolean[][] getEast();
	public boolean[][] getWest();
	public boolean[][] getSouth();
	public boolean[][] getVisited();
	int getN();
	public void generate();
	public void generate(int x, int y);
	
}
