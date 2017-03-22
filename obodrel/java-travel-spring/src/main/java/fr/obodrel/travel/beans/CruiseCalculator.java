package fr.obodrel.travel.beans;

import fr.obodrel.travel.resources.CruiseInformationsHolder;
import fr.obodrel.travel.resources.CruiseInformationsHolder.LocationEnum;

public class CruiseCalculator {

	private LocationEnum _origin;
	private LocationEnum _destination;
	private double _bergenToMalmoPrice;
	private double _helsinkiToMalmoPrice;

	public CruiseCalculator() {
		_helsinkiToMalmoPrice = CruiseInformationsHolder.HELSINKI_TO_MALMO_PRICE;
		_bergenToMalmoPrice = CruiseInformationsHolder.BERGEN_TO_MALMO_PRICE;
	}

	public LocationEnum getOrigin() {
		return _origin;
	}

	public void setOrigin(LocationEnum origin) {
		_origin = origin;
	}

	public LocationEnum getDestination() {
		return _destination;
	}

	public void setDestination(LocationEnum destination) {
		_destination = destination;
	}

	public double getPrice() {
		if (_origin == LocationEnum.BERGEN && _destination == LocationEnum.MALMO ||
				_origin == LocationEnum.MALMO && _destination == LocationEnum.BERGEN) {
			return _bergenToMalmoPrice;
		} else if (_origin == LocationEnum.HELSINKI && _destination == LocationEnum.MALMO ||
				_origin == LocationEnum.MALMO && _destination == LocationEnum.HELSINKI) {
			return _helsinkiToMalmoPrice;
		} else if (_origin == LocationEnum.HELSINKI && _destination == LocationEnum.BERGEN ||
				_origin == LocationEnum.BERGEN && _destination == LocationEnum.HELSINKI) {
			return _bergenToMalmoPrice + _helsinkiToMalmoPrice;
		}
		return 0;
	}

	public void setBergenToMalmoPrice(double newPrice) {
		_bergenToMalmoPrice = newPrice;
	}

	public void setHelsinkiToMalmoPrice(double newPrice) {
		_helsinkiToMalmoPrice = newPrice;
	}
}
