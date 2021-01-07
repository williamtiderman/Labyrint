package mazeGeneration;

import java.util.ArrayDeque;
import java.util.Deque;

public class MazeSolveTwo2nd {

	private int n;
	private boolean[][] north;     // is there a wall to north of cell i, j
	private boolean[][] east;
	private boolean[][] south;
	private boolean[][] west;
	private boolean[][] visited;


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

		while (visited == false) {
			if (x == maxX && y == maxY) {
				// Found the exit!
				System.out.println("Klart");

			} else if (x + 1 <= maxX && east[y][x + 1]) {
				// Try moving right
				stack.push(new int[]{x + 1, y});
				x++;
			}
			else if (x + 1 <= maxX && west[y][x - 1]) {
				// Try moving left
				stack.push(new int[]{x - 1, y});
				x--;
			}
			else if (x - 1 <= maxX && north[y][x - 1]) {
				// Try moving up
				stack.push(new int[]{x, y - 1});
				y--;
			}else if (y + 1 <= maxY && south[y + 1][x]) {
				// Try moving down
				stack.push(new int[]{x, y + 1});
				y++;
			}else if (!stack.isEmpty()) {
				// Mark as dead end (so we will not try to reach here again)
				//maze[y][x] = false;
				int[] current = stack.pop();
				x = current[0];
				y = current[1];
			} else {
				// No way to go -> impossible to reach the exit

			}
		}
	}
	public void solve() {
		for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
                visited[x][y] = false;
		done = false;
		solve(1,1);
	}
}
