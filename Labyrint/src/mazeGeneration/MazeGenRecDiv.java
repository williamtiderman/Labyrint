package mazeGeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazeGenRecDiv implements MazeGeneration {

	private int n; 
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private List<List<Boolean>> visited;
	MazeNode startGrid;
	Stack<MazeNode> mazeStack;


	@Override
	public void draw() {
		StdDraw.pause(50);
		StdDraw.square(n + 0.5, n + 0.5, 0.375);
		
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

	public MazeGenRecDiv(int n) {
		this.n = n;
		StdDraw.setXscale(0, n+2);
		StdDraw.setYscale(0, n+2);
		init();
		generate();
	}

	private void init() {
		// initialize border cells as already visited

		north = new ArrayList<List<Boolean>>();
		east = new ArrayList<List<Boolean>>();
		west = new ArrayList<List<Boolean>>();
		south = new ArrayList<List<Boolean>>();
		visited = new ArrayList<List<Boolean>>();

		for(int i = 0; i < n+2; i++){
			north.add(new ArrayList<Boolean>());
			east.add(new ArrayList<Boolean>());
			west.add(new ArrayList<Boolean>());
			south.add(new ArrayList<Boolean>());
			visited.add(new ArrayList<Boolean>());

			for(int j = 0; j < n+2; j++) {
				north.get(i).add(false);
				east.get(i).add(false);
				west.get(i).add(false);
				south.get(i).add(false);
			}
		}
	}


	@Override
	public List<List<Boolean>> getNorth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Boolean>> getEast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Boolean>> getWest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<List<Boolean>> getSouth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void generate() {

		mazeStack = new Stack<MazeNode>();

		for (int x = 1; x <= n; x++) {
			north.get(x).set(n,true);
			south.get(x).set(1,true);
		}
		for (int y = 1; y <= n; y++) {
			east.get(n).set(y,true);
			west.get(1).set(y,true);
		}

		Random rand = new Random();
		int startX = n/2;
		boolean horizontal = true;


		startGrid = new MazeNode(1,1,n,n);
		mazeStack.push(startGrid);

		draw();
		divide(horizontal,n,n,startGrid);

	}


	public void divide(boolean horizontal,int width,int height, MazeNode grid) {

		
		
		int startX = grid.getX();
		int startY = grid.getY();

		int endX = grid.getEndX();
		int endY = grid.getEndY();
		
		System.out.println(startX +" "+ endX);
		System.out.println(startY +" "+ endY);

		if(endX-startX < 3 || endY-startY < 3) {
			System.out.println("Okej den hittade faktiskt denna");
			return;
		}


		while(true) {
			if(horizontal) {
				Random random = new Random();
				
				int bisectInt = random.nextInt(endY-startY)+startY;
				
				int holeX = random.nextInt(endX-startX-1) +startX+1;

				for(int i = startX; i <= endX; i++) {
					if(i != holeX) {
						north.get(i).set(bisectInt,true);
						south.get(i).set(bisectInt+1,true);
					}
				}
				draw();
				int nextSquare = random.nextInt(3-1)+1;

				
				//int nextSquare = 2;
				if(endY-bisectInt > bisectInt - startY)
				{
					System.out.println("Uppåt");
					MazeNode newGrid = new MazeNode(startX,bisectInt+1,endX,endY);
					mazeStack.push(newGrid);
					
					
					
					divide(false,width,height,newGrid);
					break;
				}
				else {
					System.out.println("neråt");
					MazeNode newGrid = new MazeNode(startX,startY,endX,bisectInt);
					mazeStack.push(newGrid);
					divide(false,width,height,newGrid);
					break;
				}
			}
			else if(!horizontal) {
				Random random = new Random();
				
				int bisectInt = random.nextInt(endX-startX)+startX;
				int holeY = random.nextInt(endY-startY-1) +startY+1;

				for(int i = startY; i <= endY; i++) {
					if(i != holeY) {
						east.get(bisectInt).set(i,true);
						west.get(bisectInt+1).set(i,true);
					}
				}
				draw();
				int nextSquare = random.nextInt(3-1)+1;
				if(endX-bisectInt < bisectInt - startX)
				{
					System.out.println("vänster");
					MazeNode newGrid = new MazeNode(startX,startY,bisectInt,endY);
					mazeStack.push(newGrid);

					divide(true,width,height,newGrid);
					break;
				}
				else {

					System.out.println("höger");
					MazeNode newGrid = new MazeNode(startX+bisectInt,startY,endX,endY);
					mazeStack.push(newGrid);

					divide(true,width,height,newGrid);
					break;
				}
				/*MazeNode newGrid = null;
				divide(direction(newGrid),newGrid);*/
			}
			
			
		}
		MazeNode lastGrid = mazeStack.pop();
		divide(horizontal,width,height, lastGrid);
		System.out.println("Den kom till början");
	}
	
	private boolean direction(MazeNode newGrid) {
		if(newGrid.getX() - newGrid.getEndX() < newGrid.getY() - newGrid.getEndY()) {
			return false;
		}
		else {
			return true;
		}
	}
	

	@Override
	public List<List<Boolean>> getVisited() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generate(int x, int y) {
		// TODO Auto-generated method stub

	}

}
