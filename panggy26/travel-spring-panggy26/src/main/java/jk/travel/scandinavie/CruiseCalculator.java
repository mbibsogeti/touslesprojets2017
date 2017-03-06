package jk.travel.scandinavie;

public class CruiseCalculator {

	public enum Location {
		BERGEN, MALMO, HELSINKI
	}

	// ATTRIBUTTS //
	private Location _destination;
	private Location _origin;
	private double _priceMalmoBergen;
	private double _priceMalmoHelsinki;

	// MÉTHODES //
	public Location getDestination() {
		return _destination;
	}

	public void setDestination(Location destination) {
		_destination = destination;
	}

	public Location getOrigin() {
		return _origin;
	}

	public void setOrigin(Location origin) {
		_origin = origin;
	}

	public void setPriceMalmoBergen(double priceMalmoBergen) {
		_priceMalmoBergen = priceMalmoBergen;
	}

	public void setPriceMalmoHelsinki(double priceMalmoHelsinki) {
		_priceMalmoHelsinki = priceMalmoHelsinki;
	}

	public double getPrice() {
		// Départ de MALMO
		if (_origin == Location.MALMO) {
			if (_destination == Location.BERGEN) {
				return _priceMalmoBergen;
			}
			if (_destination == Location.HELSINKI) {
				return _priceMalmoHelsinki;
			}
			return 0;
		}
		// Départ de BERGEN
		if (_origin == Location.BERGEN) {
			if (_destination == Location.MALMO) {
				return _priceMalmoBergen;
			}
			if (_destination == Location.HELSINKI) {
				return _priceMalmoBergen + _priceMalmoHelsinki;
			}
			// Tous les chemins doivent aboutir à un return
			return 0;
		}
		// Départ d'HELSINKI
		if (_origin == Location.HELSINKI) {
			if (_destination == Location.MALMO) {
				return _priceMalmoHelsinki;
			}
			if (_destination == Location.BERGEN) {
				return _priceMalmoBergen + _priceMalmoHelsinki;
			}
			return 0;
		} else {
			return 0;
		}
	} // end getPrice method
} // end CruiseCalculator class