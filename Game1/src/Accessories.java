
public class Accessories extends Equipment {
	
		private final String[] warriorAccessories = {"Iron Bangle"};
		private final String[] thiefAccessories = {"Pendant"};
		private final String[] sorcererAccessories = {"Old Witch Ring"};

		public Accessories() {
			
		}
		
		public String getWarriorDefaultAccessory() {
			return warriorAccessories[0];
		}
		
		public String getThiefDefaultAccessory() {
			return thiefAccessories[0];
		}
		
		public String getSorcererDefaultAccessory() {
			return sorcererAccessories[0];
		}
}
