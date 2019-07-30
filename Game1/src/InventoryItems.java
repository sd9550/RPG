
public class InventoryItems {
	
	private final String[] POTION_NAMES = {"1. Potion", "2. Super Potion"};
	private final int[] POTION_VALUES = {20, 50};
	private String[] playerInventory = {POTION_NAMES[0], POTION_NAMES[1]};
	private int[] playerInventoryQuantity = {0, 0};
	private int inventorySize;

	public InventoryItems() {
		inventorySize = 0;
	}
	
	public String getPotion(int p) {
		return POTION_NAMES[p];
	}
	
	public int getPotionValue(int v) {
		return POTION_VALUES[v];
	}
	
	public void addPotion() {
		playerInventoryQuantity[0] += 1;
		inventorySize += 1;
	}
	
	public void addSuperPotion() {
		playerInventoryQuantity[1] += 1;
		inventorySize += 1;
	}
	
	public int getPotionNameSize() {
		return POTION_NAMES.length;
	}
	
	public int useItem(int i) {
		playerInventoryQuantity[i] -= 1;
		return POTION_VALUES[i];
	}
	
	public int getInventorySize() {
		int total = 0;
		if(playerInventoryQuantity[0] > 0) {
			total += 1;
		}
		if(playerInventoryQuantity[1] > 0) {
			total += 1;
		}
		return total;
	}
	
	public int getInventoryItemQuantity(int q) {
		return playerInventoryQuantity[q];
	}
	
	public String getInventory(int i) {
		String temp = "";
		
		if(playerInventoryQuantity[i] > 0) {
			temp += playerInventory[i] + " x" + playerInventoryQuantity[i];
		}
		
		return temp;
	}
	
	public int getPotionQuantity(int q) {
		return playerInventoryQuantity[q];
	}
}
