package mazeGeneration;
/**
 * @author William Tiderman
 * @author John Engblom Sandin
 * @version 2021-01-10
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGenSideWind implements MazeGeneration {

	// 2-Dimensionella listor som säger om det finns en vägg åt ett håll från positionen
	private int n; 
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private List<List<Boolean>> visited;

	private List<MazeNode> currentSet;
	private boolean done = false;


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
	public List<List<Boolean>> getVisited() {
		// TODO Auto-generated method stub
		return this.visited;
	}

	@Override
	public int getN() {
		return this.n;
	}

	/**
	 * Skapar layout för labyrint
	 * 
	 * @param n dimension för kvadraten av labyrinten
	 */
	public MazeGenSideWind(int n) {
		this.n = n;
		StdDraw.setXscale(0, n+2);
		StdDraw.setYscale(0, n+2);
		init();
		generate();
	}

	/**
	 * Ritar start/slut punkt samt väggar i labyrinten
	 */
	@Override
	public void draw() {
		StdDraw.clear();
		StdDraw.pause(10);

		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(n + 0.5, n + 0.5, 0.375);
		StdDraw.filledCircle(1.5, 1.5, 0.375);
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				if (south.get(x).get(y)) StdDraw.line(x, y, x+1, y);
				if (north.get(x).get(y)) StdDraw.line(x, y+1, x+1, y+1);
				if (west.get(x).get(y))  StdDraw.line(x, y, x, y+1);
				if (east.get(x).get(y))  StdDraw.line(x+1, y, x+1, y+1);
			}
		}

		StdDraw.show();

	}

	//init
	private void init() {
		north = new ArrayList<List<Boolean>>();
		east = new ArrayList<List<Boolean>>();
		west = new ArrayList<List<Boolean>>();
		south = new ArrayList<List<Boolean>>();
		visited = new ArrayList<List<Boolean>>();

		currentSet = new ArrayList<MazeNode>();

		for(int i = 0; i < n+2; i++){
			north.add(new ArrayList<Boolean>());
			east.add(new ArrayList<Boolean>());
			west.add(new ArrayList<Boolean>());
			south.add(new ArrayList<Boolean>());
			visited.add(new ArrayList<Boolean>());

			for(int j = 0; j < n+2; j++) {
				north.get(i).add(true);
				east.get(i).add(true);
				west.get(i).add(true);
				south.get(i).add(true);
				visited.get(i).add(true);
			}
		}	
	}
	@Override
	public void generate() {

		for (int x = 1; x <= n; x++) {
			north.get(x).set(n,true);
			south.get(x).set(1,true);
		}
		for (int y = 1; y <= n; y++) {
			east.get(n).set(y,true);
			west.get(1).set(y,true);
		}
		

		east.get(1).set(n, false);

		for(int i = 2; i < n; i++) {
			west.get(i).set(n, false);
			east.get(i).set(n, false);
		}

		west.get(n).set(n, false);

		generate(1,n-1);

		draw();


	}

	@Override
	public void generate(int x, int y) {
		if(!done) {
			if(y == 0)
			{
				done = true;
				return;
			}
			if(x == n+1 || x == n) {

				if(currentSet.size() == 0){
					north.get(x).set(y, false);
					south.get(x).set(y+1, false);
					generate(1,y-1);
				}
				else {
					carveNorth(x,y);
				}
			}
			else {
				boolean goEast = goOrStop();

				if(currentSet.size() == 0 || goEast) {
					carveEast(x,y);
				}
				else{
					carveNorth(x,y);
				}
			}
		}
	}
	/**
	 * Randomizar och den ska gå åt höger eller uppåt
	 * 
	 * @return boolean för höger eller upp
	 */
	public boolean goOrStop() {

		Random random = new Random();
		int ifgo = random.nextInt(3-1)+1;

		if(ifgo < 2) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Skär väggen till höger och kallar rekursivt på generate igen
	 * 
	 * @param x värdet på x koordinaten
	 * @param y värdet på y koordinaten
	 */
	public void carveEast(int x, int y) {
		MazeNode currentNode = new MazeNode(x,y);
		currentSet.add(currentNode);
		east.get(x).set(y, false);
		west.get(x+1).set(y, false);
		generate(x+1,y);
	}
	/**
	 * Skär väggen till höger och kallar rekursivt på generate igen
	 * 
	 * @param x värdet på x koordinaten
	 * @param y värdet på y koordinaten
	 */
	public void carveNorth(int x, int y) {

		Random random = new Random();
		int passageIndex = random.nextInt(currentSet.size());
		north.get(currentSet.get(passageIndex).getX()).set(y, false);
		south.get(currentSet.get(passageIndex).getX()).set(y+1, false);

		currentSet.clear();
		if(x == n) {
			generate(1,y-1);
		}
		else {
			generate(x+1,y);
		}


	}
}
