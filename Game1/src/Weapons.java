
public class Weapons extends Equipment {
	
	private final String[] warriorWeapons = {"Longsword", "Bastard Sword", "Claymore", "Zweihander"};
	private final int[] warriorWeaponsAttack = {5, 7, 8, 10};
	private final String[] thiefWeapons = {"Dagger", "Bandit's Knife", "Short Sword", "Ghost Blade"};
	private final int[] thiefWeaponsAttack = {2, 3, 4, 6};
	private final String[] sorcererWeapons = {"Sorcerer Rod", "Heretic's Staff", "Wizard Rod", "Mendicant's Staff"};
	private final int[] sorcererWeaponsAttack = {1, 1, 1, 1};
	
	private final String[] monsterWeapons = {"Unarmed", "Stick", "Rock"};
	private final int[] monsterWeaponsAttack = {1, 2, 2};
	
	public Weapons() {
		
	}
	
	public String getWarriorDefaultWeapon() {
		return warriorWeapons[0];
	}
	
	public String getThiefDefaultWeapon() {
		return thiefWeapons[0];
	}
	
	public String getSorcererDefaultWeapon() {
		return sorcererWeapons[0];
	}
	
	public String getWarriorWeapon(int x) {
		return warriorWeapons[x];
	}
	
	public String getThiefWeapon(int x) {
		return thiefWeapons[x];
	}
	
	public String getSorcererWeapon(int x) {
		return sorcererWeapons[x];
	}
	
	public int getWarriorWeaponAttack(int x) {
		return warriorWeaponsAttack[x];
	}
	
	public int getThiefWeaponAttack(int x) {
		return thiefWeaponsAttack[x];
	}
	
	public int getSorcererWeaponAttack(int x) {
		return sorcererWeaponsAttack[x];
	}
	
	public String getMonsterWeapon(int x) {
		return monsterWeapons[x];
	}
	
	public int getMonsterWeaponAttack(int x) {
		return monsterWeaponsAttack[x];
	}
}
