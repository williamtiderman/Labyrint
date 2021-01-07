package mazeGeneration;

import java.util.List;

public interface MazeGeneration {
	
	public void draw();
	public List<MazeNode> getMazeList();
	int getN();
	public void generate();
	public void generate(int x, int y);
	
}
