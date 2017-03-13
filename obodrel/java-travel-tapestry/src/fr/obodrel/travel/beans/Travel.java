package fr.obodrel.travel.beans;

import java.io.Serializable;

public class Travel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME = "None";
	private static final double DEFAULT_PRICE = -1;
	private static final String DEFAULT_DESCRIPTION = "None";

	private String _name;
	private double _price;
	private String _description;

	public Travel() {
		this(DEFAULT_NAME,DEFAULT_PRICE,DEFAULT_DESCRIPTION);
	}
	
	public Travel(String name, double price, String description) {
		_name = name;
		_price = price;
		_description = description;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public void setPrice(double price) {
		_price = price;
	}
	
	public double getPrice() {
		return _price;
	}
	
	public void setDescription(String description) {
		_description = description;
	}
	
	public String getDescription() {
		return _description;
	}
}
