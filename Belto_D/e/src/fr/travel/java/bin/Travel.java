package fr.travel.java.bin;
public class Travel {
	String name;
	double price;
	String description;
	
public Travel(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
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

public Travel() {
	super();
	// TODO Auto-generated constructor stub
}
}
