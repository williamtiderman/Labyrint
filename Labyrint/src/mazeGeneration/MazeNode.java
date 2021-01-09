package mazeGeneration;

public class MazeNode {
	private int x;
	private int y;
	
	private int endX;
	private int endY;
	
	private boolean north;
	private boolean east;
	private boolean west;
	private boolean south;
	private boolean visited;
	
	
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public MazeNode(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public MazeNode(int x, int y,int endX, int endY) {
		this.x = x;
		this.y = y;
		this.setEndX(endX);
		this.setEndY(endY);
	}
	
	public boolean isNorth() {
		return north;
	}
	public void setNorth(boolean north) {
		this.north = north;
	}
	public boolean isEast() {
		return east;
	}
	public void setEast(boolean east) {
		this.east = east;
	}
	public boolean isWest() {
		return west;
	}
	public void setWest(boolean west) {
		this.west = west;
	}
	public boolean isSouth() {
		return south;
	}
	public void setSouth(boolean south) {
		this.south = south;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public int getEndY() {
		return endY;
	}
	public void setEndY(int endY) {
		this.endY = endY;
	}
	public int getEndX() {
		return endX;
	}
	public void setEndX(int endX) {
		this.endX = endX;
	}
	
	
	
}
