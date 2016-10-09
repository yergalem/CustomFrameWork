package di.lib;

public enum AccountType {

	SAVING("Saving"), CHECKING("Checking"), RETIREMENT("Retirment"),
	GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze");
	
	private String catName;
	
	private AccountType(String name) {
		catName = name;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	
}
