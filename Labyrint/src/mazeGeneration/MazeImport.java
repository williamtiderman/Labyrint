package mazeGeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeImport {
	
	private int n;
	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private List<List<Boolean>> visited;

	public MazeGeneration MazeImport(String filePath) {
		
		String data = "";

		north = new ArrayList<List<Boolean>>();
		east = new ArrayList<List<Boolean>>();
		west = new ArrayList<List<Boolean>>();
		south = new ArrayList<List<Boolean>>();
		visited = new ArrayList<List<Boolean>>();
		
		MazeGeneration maze = null;
		
		
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
			}
			
		}
		
		
		return maze;
	}
	
	
}
