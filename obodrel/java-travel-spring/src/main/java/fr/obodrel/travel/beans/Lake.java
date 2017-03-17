package fr.obodrel.travel.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Entity
@Region("lakeRegion")
public class Lake implements Serializable{

	public static final Long DEFAULT_LAKE_ID = -1L;
	public static final String DEFAULT_LAKE_NAME = "NONE";
	public static final String DEFAULT_LAKE_COUNTRY = "NONE";
	public static final float DEFAULT_LAKE_SIZE = 0;

	private static final long serialVersionUID = 1L;

	private Long _id;
	private String _name;
	private String _country;
	private float _size;

	public Lake() {
		this(DEFAULT_LAKE_ID, DEFAULT_LAKE_NAME, DEFAULT_LAKE_COUNTRY, DEFAULT_LAKE_SIZE);
	}

	public Lake(Long id, String name, String country, float size) {
		_id = id;
		_name = name;
		_country = country;
		_size = size;
	}

	@Id
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	@Column(name="name",nullable=false,unique=false,length=100)
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@Column(name="country",nullable=false,unique=false,length=100)
	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	@Column(name="size",nullable=false,unique=false)
	public float getSize() {
		return _size;
	}

	public void setSize(float size) {
		_size = size;
	}

	@Override
	public String toString() {
		return "Lake [ id=" + _id + ", name = " + _name + ", country = " + _country + ", size = " + _size + "]";
	}

	@Override
	public boolean equals(Object objectToCompare) {
		if (this == objectToCompare) {
			return true;
		}
		if (objectToCompare == null || getClass() != objectToCompare.getClass()) {
			return false;
		}

		Lake lakeCompared = (Lake) objectToCompare;

		if (_id != lakeCompared._id) {
			return false;
		}

		if (_country == null) {
			if (lakeCompared._country != null) {
				return false;
			}
		} else if (!_country.equals(lakeCompared._country)) {
			return false;
		}

		if (_name == null) {
			if (lakeCompared._name != null) {
				return false;
			}
		} else if (!_name.equals(lakeCompared._name)) {
			return false;
		}

		if (Float.floatToIntBits(_size) != Float.floatToIntBits(lakeCompared._size)) {
			return false;
		}

		return true;
	}
}
