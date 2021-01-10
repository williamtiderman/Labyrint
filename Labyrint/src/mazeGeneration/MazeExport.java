package mazeGeneration;
/**
 * @author William Tiderman
 * @author John Engblom Sandin
 * @version 2021-01-10
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MazeExport {

	private List<List<Boolean>> north;
	private List<List<Boolean>> east;
	private List<List<Boolean>> west;
	private List<List<Boolean>> south;
	private int n;
	
	/**
	 * Exporterar en labyrint till en textfil.
	 * 
	 * @param maze
	 */

	public MazeExport(MazeGeneration maze) {

		this.n = maze.getN();
		this.north = maze.getNorth();
		this.east = maze.getEast();
		this.west = maze.getWest();
		this.south = maze.getSouth();
		try {
			String outPrint = "Första två siffrorna är koordinater sedan true eller false om det finns en vägg i riktningen Norr,Öst,Söder,Västerut \n";
			outPrint += String.valueOf(n)+ "\n";
			
			for(int i = 1; i <= n;i++){
				for(int j = 1; j <= n; j++){

					outPrint += i + "," + j + " " + north.get(i).get(j) + " " + east.get(i).get(j) + " " + south.get(i).get(j) + " " + west.get(i).get(j) + "\n";

				}
			}

			FileWriter myWriter = new FileWriter("MazeFile.txt");
			myWriter.write(outPrint);
			myWriter.close();

		} catch (IOException e) {
			System.out.println("Det blev fel med skrivningen");
			e.printStackTrace();
		}
	}
}
