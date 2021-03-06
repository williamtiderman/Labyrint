package mazeGeneration;
/**
 * @author William Tiderman
 * @author John Engblom Sandin
 * @version 2021-01-10
 */
import java.util.List;

public class MazeSolveDepthFirst implements MazeSolver {
	
	// 2-Dimensionella listor som säger om det finns en vägg åt ett håll från positionen
	private int n;   // dimension of maze
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private List<List<Boolean>> visited;
	private boolean done = false;
	
	public MazeSolveDepthFirst(MazeGeneration mazeGen){
		this.n = mazeGen.getN();
		this.north = mazeGen.getNorth();
		this.east = mazeGen.getEast();
		this.west = mazeGen.getWest();
		this.south = mazeGen.getSouth();
		this.visited = mazeGen.getVisited();
		
		
	}
	
    // Rekursiv metod för att lösa labyrinten med hjälp av en depth-first algoritm
    public void solve(int x, int y) {
    	
        if (x == 0 || y == 0 || x == n+1 || y == n+1) {
        	return;
        }
        	
        if (done || visited.get(x).get(y)) {
        	return;
        }
        visited.get(x).set(y,true);

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(20);

        // reached Ending
        if (x == n && y == n) done = true;
        
        
        if (!north.get(x).get(y)) {
        	solve(x, y + 1);
        }
        if (!east.get(x).get(y)) {
        	solve(x + 1, y);
        }
        if (!south.get(x).get(y)) {
        	solve(x, y - 1);
        }
        if (!west.get(x).get(y)) {
        	solve(x - 1, y);
        }
       
        if (done) return;

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(20);
    }

    // Kallar på solve metoden från startpunkten.
    public void solve() {
        for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
            	visited.get(x).set(y, false);
        done = false;
        solve(1, 1);
    }
}
