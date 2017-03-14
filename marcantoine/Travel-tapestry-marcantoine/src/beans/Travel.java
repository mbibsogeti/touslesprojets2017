package beans;

public class Travel {

	private String name, desc;
	private float price;
	
	
	public Travel() {
		super();
	}
	public Travel(String name, String desc, float price) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
