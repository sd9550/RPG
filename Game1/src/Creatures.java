
public class Creatures {
	
	protected Weapons weapons = new Weapons();
	protected Armor armors = new Armor();
	protected Accessories accessories = new Accessories();
	
	private final int[] EXP_TO_LEVEL_UP = {10, 30, 70, 150};
	private final int[] LEVELS = {2, 3, 4, 5};
	
	protected String[] genders = {"Male", "Female", "Other"};
	private String[] abilities = new String[4];
	private int[] abilitiesMana = new int[4];
	private String name;
	private String gender;
	private int level;
	private int health;
	private int maxHealth;
	private int mana;
	private int maxMana;
	private int experience;
	private int strength;
	private int agility;
	private int dexterity;
	private int intelligence;
	private int luck;
	private int experienceGained;
	private int goldAmount;
	private int goldGained;
	
	private int physicalAttack;
	private int physicalDefense;
	private int magicAttack;
	private int magicDefense;
	
	private String weapon;
	private String armor;
	private String accessory;
	
	private boolean isDead = false;
	private boolean isDeadNotify = false;
	
	public Creatures() {

	}
	
	protected void setAllStats(String n, String g, int l, int h, int m, int e, int s, int a, int i, int lu) {
		name = n;
		gender = g;
		level = l;
		health = h;
		maxHealth = h;
		mana = m;
		maxMana = m;
		experience = e;
		strength = s;
		agility = a;
		intelligence = i;
		luck = lu;
	}
	
	protected void setName(String n) {
		name = n;
	}
	
	protected void setGender(String g) {
		gender = g;
	}
	
	protected void setLevel(int l) {
		level = l;
	}
	
	protected void setHealth(int h) {
		health = h;
		maxHealth = h;
	}
	
	protected void setMana(int m) {
		mana = m;
		maxMana = m;
	}
	
	protected void setExperience(int e) {
		experience = e;
	}
	
	protected void setStrength(int s) {
		strength = s;
	}
	
	protected void setAgility(int a) {
		agility = a;
	}
	
	protected void setDexterity(int d) {
		dexterity = d;
	}
	
	protected void setIntelligence(int i) {
		intelligence = i;
	}
	
	protected void setLuck(int l) {
		luck = l;
	}
	
	protected void setExperienceGained(int e) {
		experienceGained = e;
	}
	
	protected void setGoldGained(int g) {
		goldGained = g;
	}
	
	protected void setGoldAmount(int g) {
		goldAmount = g;
	}
	
	protected void addGoldAmount(int g) {
		goldAmount += g;
	}
	
	protected void setPhysicalAttack(int p) {
		physicalAttack = p;
	}
	
	protected void setPhysicalDefense(int p) {
		physicalDefense = p;
	}
	
	protected void setMagicAttack(int m) {
		magicAttack = m;
	}
	
	protected void setMagicDefense(int m) {
		magicDefense = m;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public int getMana() {
		return mana;
	}
	
	public int getMaxMana() {
		return maxMana;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public int getExperienceGained() {
		return experienceGained;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getAgility() {
		return agility;
	}
	
	public int getDexterity() {
		return dexterity;
	}
	
	public int getIntelligence() {
		return intelligence;
	}
	
	public int getLuck() {
		return luck;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	public String getArmor() {
		return armor;
	}
	
	public String getAccessory() {
		return accessory;
	}
	
	public int getPhysicalAttackDamage() {
		return physicalAttack;
	}
	
	public int getMagicAttackDamage() {
		return magicAttack;
	}
	
	public int getGoldAmount() {
		return goldAmount;
	}
	
	public void addExperience(int e) {
		experience += e;
		// check for level up
		for(int x = 0; x < LEVELS.length; ++x) {
			if(experience >= EXP_TO_LEVEL_UP[x] && level < LEVELS[x]) {
				level += 1;
				System.out.println("Level up - You have reached level " + level);
			}
		}
	}
	
	public int getGoldGained() {
		return goldGained;
	}
	
	protected void setEquipment(String w, String ar, String ac) {
		weapon = w;
		armor = ar;
		accessory = ac;
	}
	
	protected void setAbilities(String a) {
		abilities[0] = a;
		abilities[1] = "";
		abilities[2] = "";
		abilities[3] = "";
	}
	
	protected void setAbilities(String a, String b) {
		abilities[0] = a;
		abilities[1] = b;
		abilities[2] = "";
		abilities[3] = "";
	}
	
	protected void setAbilities(String a, String b, String c) {
		abilities[0] = a;
		abilities[1] = b;
		abilities[2] = c;
		abilities[3] = "";
	}
	
	protected void setAbilities(String a, String b, String c, String d) {
		abilities[0] = a;
		abilities[1] = b;
		abilities[2] = c;
		abilities[3] = d;
	}
	
	protected void setAbilitiesMana(int a, int b, int c, int d) {
		abilitiesMana[0] = a;
		abilitiesMana[1] = b;
		abilitiesMana[2] = c;
		abilitiesMana[3] = d;
	}
	
	public String[] getAbilities() {
		return abilities;
	}
	
	public int getAbilitiesMana(int m) {
		return abilitiesMana[m];
	}
	
	public void damageHealth(int d) {
		health -= d;
		if(health <= 0) {
			isDead = true;
		}
	}
	
	//prevent healing from increasing maximum health
	public void healHealth(int h) {
		if((health + h) > maxHealth) {
			health = maxHealth;
		} else {
			health += h;
		}
	}
	
	public void damageMana(int d) {
		mana -= d;
		if(mana < 0) {
			mana = 0;
		}
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setIsDeadNotify(boolean d) {
		isDeadNotify = d;
	}
	
	public boolean isDeadNotify() {
		return isDeadNotify;
	}
	
}
