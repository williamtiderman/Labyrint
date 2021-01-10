package mazeGeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeImport implements MazeGeneration{

	private int n;
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private List<List<Boolean>> visited;
	MazeGeneration maze = null;

	public MazeImport(String filePath) {
		maze = importMaze(filePath);
	}

	public MazeGeneration importMaze(String filePath) {
		String data = "";

		north = new ArrayList<List<Boolean>>();
		east = new ArrayList<List<Boolean>>();
		west = new ArrayList<List<Boolean>>();
		south = new ArrayList<List<Boolean>>();
		visited = new ArrayList<List<Boolean>>();




		File textFile = new File(filePath);
		Scanner mazeFile = null;
		try {
			mazeFile = new Scanner(textFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (mazeFile.hasNextLine()) 
		{
			data += mazeFile.nextLine();
			data += "\n";
		}
		data = data.replaceAll(","," ");
		Scanner dataReader = new Scanner(data);
		dataReader.useDelimiter(" |\n");


		boolean firstRun = true;

		while(dataReader.hasNext())
		{
			if(firstRun) {
				firstRun = false;
				dataReader.nextLine();

				n = Integer.parseInt(dataReader.next());
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
				maze = new ImportedMaze(north,east,south,west,visited,n);
			}
			else{
				int x = Integer.parseInt(dataReader.next());
				int y = Integer.parseInt(dataReader.next());
				maze.getNorth().get(x).set(y,Boolean.parseBoolean(dataReader.next()));
				maze.getEast().get(x).set(y,Boolean.parseBoolean(dataReader.next()));
				maze.getSouth().get(x).set(y,Boolean.parseBoolean(dataReader.next()));
				maze.getWest().get(x).set(y,Boolean.parseBoolean(dataReader.next()));
				
				String systemPrint = x + "," + y + " " + north.get(x).get(y) + " " + east.get(x).get(y) + " " + south.get(x).get(y) + " " + west.get(x).get(y) + "\n";
				System.out.println(systemPrint);
			}

		}
		draw();
		dataReader.close();
		return maze;
	}

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
		// TODO Auto-generated method stub

	}

	@Override
	public void generate(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<List<Boolean>> getVisited() {
		// TODO Auto-generated method stub
		return null;
	}


}
