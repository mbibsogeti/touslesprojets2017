package fr.obodrel.travel.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monument"/*,schema="travel_obodrel"*/)
public class Monument implements Serializable{

	public static final String LOCATION_UNKNOWN = "UNKNOWN";
	public static final String NAME_UNDEFINED = "UNDEFINED";
	public static final String VALUE_TBD = "TBD";
	public static final String VALUE_TBA = "TBA";
	public static final int MAX_VISITORS_UNDEFINED = -1;	
		
	private static final long serialVersionUID = 1L;
	
	private int _id;
	private String _name;
	private String _location;
	private int _maxVisitors;
	
	public Monument() {
		this(NAME_UNDEFINED,LOCATION_UNKNOWN,MAX_VISITORS_UNDEFINED);
	}
	
	public Monument(String name, String location) {
		this(name,location,MAX_VISITORS_UNDEFINED);
	}
	
	public Monument(String name, String location, int maxVisitors) {
		_name = name;
		_location = location;
		_maxVisitors = maxVisitors;
		_id = 0;
	}
	
	@Column @Id @GeneratedValue
	public int getID() {
		return _id;
	}
	
	public void setID(int id) {
		_id = id;
	}
	
	
	@Column(name="name",length=100,nullable=false,unique=false)
	public String getName() {
		System.out.println("getname");
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}

	@Column(name="location",length=100,nullable=false,unique=false)
	public String getLocation() {
		return _location;
	}
	
	public void setLocation(String location) {
		_location = location;
	}

	@Column(name="max_visitors",nullable=false,unique=false)
	public int getMaxVisitors() {
		return _maxVisitors;
	}
	
	public void setMaxVisitors(int maxVisitors) {
		_maxVisitors = maxVisitors;
	}
	
	
}
