package fr.ib.travel.tapestry.beans;

public class Travel {
	
	private String name, description;
	private float price;
	
	
	
	public Travel() {
		name="";
		description="";
		price=0;
	}

	public Travel(String name, String description, float price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
	
}
