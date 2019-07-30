
public class Equipment {
	
	private String name;
	private String description;
	
	public Equipment() {
		
	}
	
	protected void setName(String n) {
		name = n;
	}
	
	protected void setDescription(String d) {
		description = d;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}
