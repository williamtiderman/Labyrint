package mazeGeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGenSideWind implements MazeGeneration {

	private int n; 
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	

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
	public int getN() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public MazeGenSideWind(int n) {
		this.n = n;
		StdDraw.setXscale(0, n+2);
		StdDraw.setYscale(0, n+2);
		init();
		generate();
	}
	
	@Override
	public void draw() {
		StdDraw.clear();
		StdDraw.pause(50);
		
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
	
	
	private void init() {
		// initialize border cells as already visited

		north = new ArrayList<List<Boolean>>();
		east = new ArrayList<List<Boolean>>();
		west = new ArrayList<List<Boolean>>();
		south = new ArrayList<List<Boolean>>();

		for(int i = 0; i < n+2; i++){
			north.add(new ArrayList<Boolean>());
			east.add(new ArrayList<Boolean>());
			west.add(new ArrayList<Boolean>());
			south.add(new ArrayList<Boolean>());

			for(int j = 0; j < n+2; j++) {
				north.get(i).add(true);
				east.get(i).add(true);
				west.get(i).add(true);
				south.get(i).add(true);
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
		


		draw();
		
		east.get(1).set(n, false);
		
		for(int i = 2; i < n; i++) {
			west.get(i).set(n, false);
			east.get(i).set(n, false);
		}
		
		west.get(n).set(n, false);
		
		draw();
		
		//generate(1,n);
		

	}

	@Override
	public void generate(int x, int y) {
		
		
		
		if(x == n && y != 1)
		{
			generate(1,y-1);
		}
		
		boolean goEast = goOrStop();
		
		if(goEast) {
			
			
			
		}
		
		

	}
	
	public boolean goOrStop() {
		
		Random random = new Random();
		int ifgo = random.nextInt(3+1)+1;
		
		if(ifgo == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

	@Override
	public List<List<Boolean>> getVisited() {
		// TODO Auto-generated method stub
		return null;
	}



}
