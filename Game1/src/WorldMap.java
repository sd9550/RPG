import java.util.Random;

public class WorldMap {
	
	private Random ran = new Random();
	private int[][] worldMap = {{1, 1, 1, 1, 1, 1},
	                            {1, 1, 1, 1, 1, 1},
	                            {1, 1, 1, 1, 1, 1},
	                            {1, 1, 1, 1, 1, 1}};
													
	private final String[] terrainName = {"grass", "forest", "lake"};
	private final int[] terrainNum = {0, 1, 2};
	private int playerLocationX, playerLocationY;
	
	public WorldMap() {
		generateWorld();
	}
	
	// populate multi array with random terrain
	private void generateWorld() {
		int num;
		
		for(int x = 0; x < worldMap.length; ++x) {
			for(int y = 0; y < worldMap[x].length; ++y) {
				num = ran.nextInt(terrainNum.length);
				worldMap[x][y] = terrainNum[num];
			}
		}
		/*
		for(int x = 0; x < worldMap.length; ++x) {
			for(int y = 0; y < worldMap[x].length; ++y) {
				System.out.print(worldMap[x][y] + " ");
			}
			System.out.println("\n");
		} */
		
		playerLocationX = ran.nextInt(worldMap.length);
		playerLocationY = ran.nextInt(worldMap[0].length);
		
		System.out.println("Player is currently located at " + playerLocationX + " " + playerLocationY);
		num = worldMap[playerLocationX][playerLocationY];
		System.out.println("Terrain: " + terrainName[num]);
	}
	
	public String getTerrain() {
		int pos = worldMap[playerLocationX][playerLocationY];
		return terrainName[pos];
	}
	
	// randomize player location
	public void movePlayer() {
		playerLocationX = ran.nextInt(worldMap.length);
		playerLocationY = ran.nextInt(worldMap[0].length);
	}
}
