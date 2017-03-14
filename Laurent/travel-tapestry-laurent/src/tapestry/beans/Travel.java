package tapestry.beans;

public class Travel {

	private String name;
	private double price;
	private String description;
	
	
	//CONSTRUCTEUR (sans attribut)
	public Travel() {
		this(null,0.00d,null);
	}

	//CONSTRUCTEUR (avec attribut)
	public Travel(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	//ACCESSEUR
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
}
