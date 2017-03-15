package fr.ib.travel.jbeans;

public class Travel {

	private String name;
	private double price;
	private String description;


	public Travel() {
		name=null;
		price=0;
		description=null;
	}

	public Travel(String _name, double _price, String _description) {
		name = _name;
		price = _price;
		description = _description;
	}
	
	//appel des fonctions booléennes toujours avec is...
	public boolean isCheap(){
		return this.getPrice()<70;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
}
