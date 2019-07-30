
public class Goblin extends Creatures {
	
		private final int goblinDamage = weapons.getMonsterWeaponAttack(1);
		private final String goblinWeapon = weapons.getMonsterWeapon(0);
		private final String image = "-{';'}-";
		private final String[] abilities = {"Swipe"};

		public Goblin() {
			this.setName("Slime");
			this.setGender(genders[2]);
			this.setLevel(1);
			this.setHealth(5);
			this.setMana(0);
			this.setExperience(0);
			this.setStrength(1);
			this.setAgility(1);
			this.setDexterity(1);
			this.setIntelligence(1);
			this.setLuck(1);
			this.setExperienceGained(6);
			this.setAbilities(abilities[0]);
			this.setPhysicalAttack(goblinDamage);
			this.setPhysicalDefense(0);
			this.setGoldGained(3);
			this.setEquipment(goblinWeapon, "None", "None");
		}
		
		public String getImage() {
			return image;
		}
}
