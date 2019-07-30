
public class Slime extends Creatures {
	
		private final String[] abilities = {"Attack", "Bounce"};
		private final int slimeDamage = weapons.getMonsterWeaponAttack(0);
		private final String slimeWeapon = weapons.getMonsterWeapon(0);
		private final String image = "(0_0)";

		public Slime() {
			this.setName("Slime");
			this.setGender(genders[2]);
			this.setLevel(1);
			this.setHealth(4);
			this.setMana(0);
			this.setExperience(0);
			this.setStrength(1);
			this.setAgility(1);
			this.setDexterity(1);
			this.setIntelligence(1);
			this.setLuck(1);
			this.setExperienceGained(5);
			this.setAbilities(abilities[0], abilities[1]);
			this.setPhysicalAttack(slimeDamage);
			this.setPhysicalDefense(0);
			this.setGoldGained(2);
			this.setEquipment(slimeWeapon, "None", "None");
		}
		
		public String getImage() {
			return image;
		}
}
