/**
 * This class describes a 10 by 10 map of areas.
 * @author jackroberts
 *
 */
public class Map {
	
	private Area[][] grid; //2D array representing 2D grid of cells.
	public final int MAX_MAP_SIZE = 5; //Maximum allowed horiz and vert size
	// of map.
	
	
	
	/**
	 * Constructor for Map(). Initialises a blank map, or a map loaded from file.
	 */
	public Map() {
		generateBlankMap();
	}
	
	/**
	 * Provides a description of the area at given coordinates.
	 * @param x The x coordinate of the desired area.
	 * @param y The y coordinate of the desired area.
	 * @return String description of specified area.
	 */
	public String getDescription(int x, int y) {
		return grid[x][y].getDescription();
	}
	
	/**
	 * Initialises this map to a blank map.
	 */
	private void generateBlankMap() {
		
		grid = new Area[MAX_MAP_SIZE][MAX_MAP_SIZE]; //Map grid becomes 2D array of Areas.
		
		//Iterate through map, adding new Area to each cell.
		for (int i = 0; i < MAX_MAP_SIZE; i++) {
			for (int j = 0; j < MAX_MAP_SIZE; j++) {
				//New blank Area gets added to every cell.
				Area blankArea = new Area("You look around. There's nothing here.", 0, null);
				grid[i][j] = blankArea;
			}
		}
	}

	/**
	 * Provides any Monster currently in specified area.
	 * @param x The x coordinate of the desired area.
	 * @param y The y coordinate of the desired area.
	 * @return Actor that is at the specified area. If no Actor is found, returns null.
	 */
	public Actor getMonsterAt(int x, int y) {
		return grid[x][y].getMonster();
	}

}
