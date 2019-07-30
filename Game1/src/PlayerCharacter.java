import java.util.ArrayList;
import java.util.Scanner;

public class PlayerCharacter extends Creatures {
	
	private Scanner scan = new Scanner(System.in);
	InventoryItems items = new InventoryItems();
	
	private final String[] classList = {"Warrior", "Thief", "Sorcerer"};
	private final String warriorDesc = "Fearless warrior. Weapon expert. High strength, dexterity.";
	private final String thiefDesc = "Guilt-ridden thief with quiet footsteps. High dexterity. Has Master Key by default.";
	private final String sorcererDesc = "Sorcerer of Vinheim. Dragon school. High Intelligence. Casts soul sorceries.";
	private final String[] classDesc = {warriorDesc, thiefDesc, sorcererDesc};
	private final String[] warriorAbilities = {"Attack", "Defend", "Item", "Run"};
	private final String[] thiefAbilities = {"Attack", "Steal", "Item", "Run"};
	private final String[] sorcererAbilities = {"Attack", "Fireball", "Item", "Run"};
	private final String[][] classAbilities = {warriorAbilities, thiefAbilities, sorcererAbilities};
	private final int[] warriorAbilitiesMana = {0, 0, 0, 0};
	private final int[] thiefAbilitiesMana = {0, 0, 0, 0};
	private final int[] sorcererAbilitiesMana = {0, 10, 0, 0};
	private final int[][] classAbilitiesMana = {warriorAbilitiesMana, thiefAbilitiesMana, sorcererAbilitiesMana};
	private String uniqueAbility, warriorUnique;
	private final int[][] classStats = {{1, 100, 10, 1, 1, 1, 1, 1, 1}, {1, 80, 40, 0, 1, 1, 1, 1, 1, 1}, {1, 60, 100, 1, 1, 1, 1, 1, 1}};
	//private ArrayList<String> playerInventory = new ArrayList<String>();

	
	private String playerClass;
	private String entry;
	private int entryNum = 0;
	
	public PlayerCharacter() {
		items.addPotion();
		items.addSuperPotion();
		createCharacter();
	}
	
	private void createCharacter() {
		boolean validEntry = false;
		
		do {
			System.out.print("Enter character name >>");
			entry = scan.nextLine();
			
			if(entry.length() == 0) {
				System.out.println("\nPlease enter a name\n");
			} else {
				validEntry = true;
			}
		}
		while(!validEntry);
		
		this.setName(entry);
		validEntry = false;
		
		System.out.println("Please select a gender\nGender does not influence stats\n");
		
		for(int x = 0; x < this.genders.length; ++x) {
			System.out.println((x + 1) + ". " + genders[x]);
		}
		
		do {
			System.out.print("Enter a number >>");
			entry = scan.nextLine();
			
			try {
				entryNum = Integer.parseInt(entry);
			} catch(Exception e) {
				System.out.println("Error:" + e.getMessage());
			}
			
			if(entryNum >= 1 && entryNum <= this.genders.length) {
				validEntry = true;
			} else {
				System.out.println("Please enter a valid number");
			}
			
		} while(!validEntry);
		
		this.setGender(this.genders[entryNum - 1]);
		validEntry = false;
		entryNum = 0;
		System.out.println("\nPlease select a class\n");
		
		for(int x = 0; x < classList.length; ++x) {
			System.out.println((x + 1) + ". " + classList[x]);
		}
		
		do {
			System.out.print("Enter a number >>");
			entry = scan.nextLine();
			
			try {
				entryNum = Integer.parseInt(entry);
			} catch(Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			if(entryNum >= 1 && entryNum <= classList.length) {
				System.out.println(classDesc[entryNum - 1]);
				System.out.print("Is this class okay? (y/n) >>");
				entry = scan.nextLine();
				
				if(entry.equals("y") || entry.equals("Y")) {
					validEntry = true;
				} else if (!entry.equals("N") && !entry.equals("n")) {
					System.out.println("Please enter a valid entry");
				}
				
			} else {
				System.out.println("Please enter a valid number");
			}
			
		} while(!validEntry);
		
		entryNum -= 1;
		playerClass = classList[entryNum];
		validEntry = false;
		
		this.setLevel(classStats[entryNum][0]);
		this.setHealth(classStats[entryNum][1]);
		this.setMana(classStats[entryNum][2]);
		this.setExperience(classStats[entryNum][3]);
		this.setStrength(classStats[entryNum][4]);
		this.setAgility(classStats[entryNum][5]);
		this.setDexterity(classStats[entryNum][6]);
		this.setIntelligence(classStats[entryNum][7]);
		this.setLuck(classStats[entryNum][8]);
		this.setGoldAmount(0);
		
		if(playerClass == classList[0]) {
			this.setEquipment(weapons.getWarriorDefaultWeapon(), armors.getWarriorDefaultArmor(), accessories.getWarriorDefaultAccessory());
			this.setAbilities(warriorAbilities[0], warriorAbilities[1], warriorAbilities[2], warriorAbilities[3]);
			this.setAbilitiesMana(warriorAbilitiesMana[0], warriorAbilitiesMana[0], warriorAbilitiesMana[0], warriorAbilitiesMana[0]);
			this.setPhysicalAttack(weapons.getWarriorWeaponAttack(0));
			this.setPhysicalDefense(armors.getWarriorArmorPhysicalDefense(0));
			warriorUnique = warriorAbilities[1];
		} else if(playerClass == classList[1]) {
			this.setEquipment(weapons.getThiefDefaultWeapon(), armors.getThiefDefaultArmor(), accessories.getThiefDefaultAccessory());
			this.setAbilities(thiefAbilities[0], thiefAbilities[1], thiefAbilities[2], thiefAbilities[3]);
			this.setPhysicalAttack(weapons.getThiefWeaponAttack(0));
			uniqueAbility = thiefAbilities[1];
		} else {
			this.setEquipment(weapons.getSorcererDefaultWeapon(), armors.getSorcererDefaultArmor(), accessories.getSorcererDefaultAccessory());
			this.setAbilities(sorcererAbilities[0], sorcererAbilities[1], sorcererAbilities[2], sorcererAbilities[3]);
			this.setPhysicalAttack(weapons.getSorcererWeaponAttack(0));
			this.setMagicAttack(10);
			uniqueAbility = sorcererAbilities[1];
		}
		
		System.out.println("Name: " + this.getName() + "\nGender: " + this.getGender() + "\nClass: " + playerClass + "\nLevel: " + this.getLevel());
		System.out.println("Weapon: " + this.getWeapon() + ", Armor: " + this.getArmor() + ", accessory: " + this.getAccessory());
		
	}
	
	public String getUniqueAbility() {
		return uniqueAbility;
	}
	
	public String getPlayerClass() {
		return playerClass;
	}
	/*
	public ArrayList<String> getInventory() {
		return playerInventory;
	}
	*/
	public int getInventorySize() {
		return items.getInventorySize();
	}
	
	public String getInventory(int i) {
		return items.getInventory(i);
	}
	
	public void useItem(int i) {
		healHealth(items.getPotionValue(i));
		items.useItem(i);
	}
} 
