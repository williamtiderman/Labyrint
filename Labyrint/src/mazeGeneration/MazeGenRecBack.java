package mazeGeneration;
/**
 * @author William Tiderman
 * @author John Engblom Sandin
 * @version 2021-01-10
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class MazeGenRecBack implements MazeGeneration{

	// 2-Dimensionella listor som säger om det finns en vägg åt ett håll från positionen
	private int n;               
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private List<List<Boolean>> visited;
	Stack<MazeNode> mazeStack;
	MazeNode startNode;


	/**
	 * Ritar ut en röd cirkel för startpunk och slutpunkt samt skapar labyrintens väggar
	 * 
	 * @param currentNode, hämtar värdet för vilket X och Y som är noden för alla riktningar 
	 */
	public void draw(MazeNode currentNode) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(n + 0.5, n + 0.5, 0.375);
		StdDraw.filledCircle(1.5, 1.5, 0.375);

		StdDraw.setPenColor(StdDraw.BLACK);
		
		if (south.get(currentNode.getX()).get(currentNode.getY())) StdDraw.line(currentNode.getX(), currentNode.getY(), currentNode.getX()+1, currentNode.getY());
		if (north.get(currentNode.getX()).get(currentNode.getY())) StdDraw.line(currentNode.getX(), currentNode.getY()+1, currentNode.getX()+1, currentNode.getY()+1);
		if (west.get(currentNode.getX()).get(currentNode.getY()))  StdDraw.line(currentNode.getX(), currentNode.getY(), currentNode.getX(), currentNode.getY()+1);
		if (east.get(currentNode.getX()).get(currentNode.getY()))  StdDraw.line(currentNode.getX()+1, currentNode.getY(), currentNode.getX()+1, currentNode.getY()+1);
	}

	/**
	 * Ritar ut röd cirkel för slut och starpunkt samt ritar labyrintens väggar ut
	 */
	public void draw(){
		StdDraw.clear();
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

	public List<List<Boolean>> getNorth(){
		return this.north;
	}
	public List<List<Boolean>> getEast(){
		return this.east;
	}
	public List<List<Boolean>> getWest(){
		return this.west;
	}
	public List<List<Boolean>> getSouth(){
		return this.south;
	}
	public List<List<Boolean>> getVisited(){
		return this.visited;
	}

	public int getN() {
		return n;
	}

	// Initialisation för listorna och bestämma att alla väggar är uppe
	private void init() {
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
				north.get(i).add(true);
				east.get(i).add(true);
				west.get(i).add(true);
				south.get(i).add(true);
				visited.get(i).add(false);
			}
		}
	}

	/** 
	 * Generar labyrinten
	 */
	public void generate() {
		mazeStack = new Stack<MazeNode>();

		for (int x = 0; x < n+2; x++) {
			visited.get(x).set(0,true);
			visited.get(x).set(n+1,true);
		}
		for (int y = 0; y < n+2; y++) {
			visited.get(0).set(y,true);
			visited.get(n+1).set(y,true);
		}

		Random rand = new Random();
		int randX = rand.nextInt(n-1) +1;
		int randY = rand.nextInt(n-1) +1;

		startNode = new MazeNode(randX, randY);

		generate(randX,randY);

		draw();
	}

	public MazeGenRecBack(int n) {
		this.n = n;
		StdDraw.setXscale(0, n+2);
		StdDraw.setYscale(0, n+2);
		init();
		generate();
	}

	/**
	 * Generar labyrint med hjälp av rekursiv backtracking
	 * 
	 * @param x, värdet för x axeln
	 * @param y, värdet för y axeln
	 */
	public void generate(int x, int y) {
		MazeNode currentNode = new MazeNode(x,y);
		
		visited.get(x).set(y, true);

		if(!visited.get(x).get(y+1) || !visited.get(x).get(y-1) || !visited.get(x+1).get(y) || !visited.get(x-1).get(y)) {
			
			while(true)
			{
				Random rand = new Random();
				int p = rand.nextInt(4);
				if(p == 0 && !visited.get(x).get(y+1)) {

					//Går uppåt
					mazeStack.push(currentNode);
					north.get(x).set(y, false);
					south.get(x).set(y+1, false);
					draw(currentNode);
					generate(x, y + 1);
					break;
				}
				if(p == 1 && !visited.get(x).get(y-1)) {

					//Går neråt
					mazeStack.push(currentNode);
					south.get(x).set(y, false);
					north.get(x).set(y-1, false);
					draw(currentNode);
					generate(x, y - 1);
					break;
				}
				if(p == 2 && !visited.get(x+1).get(y)) {

					//Går åt höger
					mazeStack.push(currentNode);
					east.get(x).set(y, false);
					west.get(x+1).set(y, false);
					draw(currentNode);
					generate(x+1, y);
					break;
				}
				if(p == 3 && !visited.get(x-1).get(y)) {

					//Går åt vänster
					mazeStack.push(currentNode);
					west.get(x).set(y, false);
					east.get(x-1).set(y, false);
					draw(currentNode);
					generate(x-1, y);
					break;
				}
			}
			MazeNode lastNode = mazeStack.pop();

			if(lastNode.getX() == startNode.getX() && lastNode.getY() == startNode.getY()){
				return;
			}
			else{
				generate(lastNode.getX(),lastNode.getY());
			}
		}
	}
}
