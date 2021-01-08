package mazeGeneration;

import java.util.List;

public interface MazeGeneration {
	
	public void draw();
	public List<List<Boolean>> getNorth();
	public List<List<Boolean>> getEast();
	public List<List<Boolean>> getWest();
	public List<List<Boolean>> getSouth();
	int getN();
	public void generate();
	public void generate(int x, int y);
	public List<List<Boolean>> getVisited();
	
}
