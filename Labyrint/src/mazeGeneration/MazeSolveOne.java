package mazeGeneration;

public class MazeSolveOne {
	
	private int n;                 // dimension of maze
	private boolean[][] north;     // is there a wall to north of cell i, j
	private boolean[][] east;
	private boolean[][] south;
	private boolean[][] west;
	private boolean[][] visited;
	private boolean done = false;
	
    // solve the maze using depth-first search
    private void solve(int x, int y) {
        if (x == 0 || y == 0 || x == n+1 || y == n+1) return;
        if (done || visited[x][y]) return;
        visited[x][y] = true;

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();

        //StdDraw.pause(30);fsad


        // reached Ending
        if (x == n && y == n) done = true;

        if (!north[x][y]) {
        	solve(x, y + 1);
        }
        if (!east[x][y]) {
        	solve(x + 1, y);
        }
        if (!south[x][y]) {
        	solve(x, y - 1);
        }
        if (!west[x][y]) {
        	solve(x - 1, y);
        }

        if (done) return;

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledCircle(x + 0.5, y + 0.5, 0.25);
        StdDraw.show();
        System.out.println("Fel Väg");
        //StdDraw.pause(5);
    }

    // solve the maze starting from the start state
    public void solve() {
        for (int x = 1; x <= n; x++)
            for (int y = 1; y <= n; y++)
                visited[x][y] = false;
        done = false;
        solve(1, 1);
    }
}
