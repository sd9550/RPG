import java.util.Scanner;

public class Initialize {
	
	private Scanner scan = new Scanner(System.in);
	private PlayerCharacter player;
	private WorldMap worldMap;
	private boolean quitGame = false;
	private String entry;

	public Initialize() {
		System.out.println("Game Program 1 - Basic RPG\n");
		createCharacter();
		createWorld();
		startGame();
	}
	
	private void createCharacter() {
		player = new PlayerCharacter();
	}
	
	// randomly generate the game world
	private void createWorld() {
		worldMap = new WorldMap();
	}
	
	private void startGame() {
		do {
			System.out.println("Currently on terrain type " + worldMap.getTerrain());
			System.out.print("Enter a command (v to view all commands) >>");
			entry = scan.nextLine();
			
			if(entry.equals("v")) {
				System.out.println("m - move\ns - stats\ne - equipment\nq - quit");
			} else if(entry.equals("m")) {
				worldMap.movePlayer();
				new MoveEvent(player);
			} else if(entry.equals("s")) {
				System.out.println("\nName: " + player.getName() + " Class: " + player.getPlayerClass() + " Level: " + player.getLevel());
				System.out.println("Experience: " + player.getExperience() + " Health: " + player.getHealth() + "/" + player.getMaxHealth() + " Mana: " + player.getMaxMana() + "/" + player.getMana());
				System.out.println("Gold: " + player.getGoldAmount());
			} else if(entry.equals("e")) {
				System.out.println("Weapon: " + player.getWeapon() + " Armor: " + player.getArmor() + " Accessory: " + player.getAccessory());
			} else if(entry.equals("q")) {
				quitGame = true;
			} else {
				System.out.println("Please enter a valid command");
			}
		} while(!quitGame);
		
		scan.close();
	}
}
