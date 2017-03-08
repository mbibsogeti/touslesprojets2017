package fr.obodrel.travel.beans;

import fr.obodrel.travel.resources.CruiseInformationsHolder.LocationEnum;

public class CruiseSource {
	private CruiseCalculator _calculator;

	public boolean getActive() {
		return true;
	}

	public CruiseCalculator getCalculator() {
		return _calculator;
	}

	public void setCalculator(CruiseCalculator calculator) {
		_calculator = calculator;
	}

	private String getOriginDestinationPrice(LocationEnum origin, LocationEnum destination) {
		_calculator.setOrigin(origin);
		_calculator.setDestination(destination);
		return origin.toString().substring(0, 1) + origin.toString().substring(1).toLowerCase() + " to "
				+ destination.toString().substring(0, 1) + destination.toString().substring(1).toLowerCase()
				+ " for only " + _calculator.getPrice() + "€.";
	}

	public String getHelsinkiBergen() {
		return getOriginDestinationPrice(LocationEnum.HELSINKI, LocationEnum.BERGEN);
	}
}
