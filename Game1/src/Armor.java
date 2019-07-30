
public class Armor extends Equipment {
	
		private final String[] warriorArmor = {"Leather Armor", "Iron Armor", "Steel Armor"};
		private final String[] thiefArmor = {"Cloth Armor", "Leather Armor", "Reinforced Leather Armor"};
		private final String[] sorcererArmor = {"Cloth Robe", "Sorcerer's Robe", "Robe of Lords"};
		private final int[] warriorArmorPhysicalDefense = {4, 6, 8};
		private final int[] warriorArmorMagicDefense = {2, 2, 2};
		private final int[] thiefArmorPhysicalDefense = {1, 4,  6};
		private final int[] thiefArmorMagicDefense = {2, 2, 2};
		private final int[] sorcererArmorPhysicalDefense = {1, 2, 3};
		private final int[] sorcererArmorMagicDefense = {2, 2, 2};

		public Armor() {
			
		}
		
		public String getWarriorDefaultArmor() {
			return warriorArmor[0];
		}
		
		public String getThiefDefaultArmor() {
			return thiefArmor[0];
		}
		
		public String getSorcererDefaultArmor( ) {
			return sorcererArmor[0];
		}
		
		public String getWarriorArmor(int x) {
			return warriorArmor[x];
		}
		
		public int getWarriorArmorPhysicalDefense(int x) {
			return warriorArmorPhysicalDefense[x];
		}
}
