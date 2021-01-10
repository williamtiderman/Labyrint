package mazeGeneration;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MazeSolveTwo2nd {

	private int n;
	private List<List<Boolean>> north;     // is there a wall to north of cell i, j
	private List<List<Boolean>> east;
	private List<List<Boolean>> south;
	private List<List<Boolean>> west;
	private List<List<Boolean>> visited;
	private boolean done = false;


	public MazeSolveTwo2nd(MazeGeneration mazeGen) {
		this.n = mazeGen.getN();
		this.north = mazeGen.getNorth();
		this.east = mazeGen.getEast();
		this.west = mazeGen.getWest();
		this.south = mazeGen.getSouth();
		this.visited = mazeGen.getVisited();
	}
	private void solve(int x, int y) {
		int maxY = n - 1;
		int maxX = n - 1;

		Deque<int[]> stack = new ArrayDeque<>();

		StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        StdDraw.pause(20);
        
		while (visited.get(x).get(y) == false) {
			if (x == maxX && y == maxY) {
				// Found the exit!
				System.out.println("Klart");
				done = true;

			} else if (x + 1 <= maxX && east.get(y).get(x+1)) {
				// Try moving right
				stack.push(new int[]{x + 1, y});
				x++;
			}
			else if (x + 1 <= maxX && west.get(y).get(x-1)) {
				// Try moving left
				stack.push(new int[]{x - 1, y});
				x--;
			}
			else if (x - 1 <= maxX && north.get(y+1).get(x)) {
				// Try moving up
				stack.push(new int[]{x, y + 1});
				y++;
			}else if (y + 1 <= maxY && south.get(y-1).get(x)) {
				// Try moving down
				stack.push(new int[]{x, y - 1});
				y--;
			}else if (!stack.isEmpty()) {
				// Mark as dead end (so we will not try to reach here again)
				// = false;
				int[] current = stack.pop();
				x = current[0];
				y = current[1];
			} else {
				// No way to go -> impossible to reach the exit

			}
			if (done) return;
			StdDraw.setPenColor(StdDraw.GRAY);
	        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
	        StdDraw.show();
	        StdDraw.pause(20);
		}
	}
	public void solve() {
		for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
                visited.get(x).set(y, false);
		done = false;
		solve(1,1);
	}
}
