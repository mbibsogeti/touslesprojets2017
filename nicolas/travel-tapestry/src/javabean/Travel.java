package javabean;

public class Travel {
	
	private String name, description;
	private double price;
	
	public Travel(){
		name="";
		description="";
		price= 0;
		
		
		
	}

	/**
	 * @return the rialprice
	 */
	
	/**
	 * @param rialprice the rialprice to set
	 */


	public Travel(String name, String description, double price) {
		super();
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

	public double getPrice() {
		return price;
	}

	
	public void setPrice(double price) {
		this.price = price;
	}

	

}
