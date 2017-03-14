package jk.travel.beans;

public class Travel {

	// ATTRIBUTS //
	private String name;
	private double price;
	private String description;
	
	// MÉHODES //
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Travel() {
		name = "";
		price = 0;
		description = "";
	}

	public Travel(String nom, double prix, String descr) {
		name = nom;
		price = prix;
		description = descr;
	}

	public boolean isCheaperThan1000() {
		return (price < 1000);
	}
} // end Travel class