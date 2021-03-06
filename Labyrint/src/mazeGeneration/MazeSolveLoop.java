package mazeGeneration;
/**
 * @author William Tiderman
 * @author John Engblom Sandin
 * @version 2021-01-10
 */
import java.util.List;
import java.util.Stack;

public class MazeSolveLoop implements MazeSolver {

	// 2-Dimensionella listor som säger om det finns en vägg åt ett håll från positionen
	private int n;
	private List<List<Boolean>> north;     
	private List<List<Boolean>> east;
	private List<List<Boolean>> south;
	private List<List<Boolean>> west;
	private List<List<Boolean>> visited;
	private boolean done = false;
	Stack<MazeNode> stack;

	public MazeSolveLoop(MazeGeneration mazeGen) {
		this.n = mazeGen.getN();
		this.north = mazeGen.getNorth();
		this.east = mazeGen.getEast();
		this.west = mazeGen.getWest();
		this.south = mazeGen.getSouth();
		this.visited = mazeGen.getVisited();
	}
	public void solve(int x, int y) {
		stack = new Stack<MazeNode>();

		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
		StdDraw.show();
		StdDraw.pause(20);

		visited.get(1).set(1,true);
		MazeNode startNode = new MazeNode(1,1);
		stack.push(startNode);

		while (true) {
			draw(true,x,y);
			
			if (x == n && y == n) {
				// Hittade slutpunkten
				done = true;
			} 
			else if (x + 1 <= n && !east.get(x).get(y) && !visited.get(x+1).get(y)) {
				// Försöker flytta höger
				MazeNode thisNode = new MazeNode(x,y);
				visited.get(x).set(y,true);
				stack.push(thisNode);
				x++;
			}
			else if (y + 1 <= n && !north.get(x).get(y) && !visited.get(x).get(y+1)) {
				// Försöker flytta up
				MazeNode thisNode = new MazeNode(x,y);
				visited.get(x).set(y,true);
				stack.push(thisNode);
				y++;
			}
			else if (y - 1 > 0 && !south.get(x).get(y) && !visited.get(x).get(y-1)) {
				// Försöker flytta nedåt
				MazeNode thisNode = new MazeNode(x,y);
				visited.get(x).set(y,true);
				stack.push(thisNode);
				y--;
			}
			else if (x - 1 > 0 && !west.get(x).get(y) && !visited.get(x-1).get(y)) {
				// Försöker flytta vänster
				MazeNode thisNode = new MazeNode(x,y);
				visited.get(x).set(y,true);
				stack.push(thisNode);
				x--;
			}
			
			else if (!stack.isEmpty()) {
			
				visited.get(x).set(y,true);
				draw(false,x,y);

				MazeNode lastNode = stack.pop();
				x = lastNode.getX();
				y = lastNode.getY();
			} 
			else {
				// Ingen utväg hittades
				break;
			}
			if (done) return;
		}
	}
	/**
	 * Ritar ut en blå en grå cirkel på noden
	 * 
	 * @param blue ett sant/falskt värde för att veta vilken färg som ska ritas
	 * @param x nodens x värde
	 * @param y nodens y värde
	 */
	public void draw(boolean blue, int x, int y) {
		if(blue) {
			StdDraw.setPenColor(StdDraw.GREEN);
		}
		else {
			StdDraw.setPenColor(StdDraw.GRAY);
		}	
		StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.show();
		StdDraw.pause(20);
	}
	
	
	public void solve() {
		for (int x = 1; x <= n; x++)
			for (int y = 1; y <= n; y++)
				visited.get(x).set(y, false);
		done = false;
		solve(1,1);
	}
}
