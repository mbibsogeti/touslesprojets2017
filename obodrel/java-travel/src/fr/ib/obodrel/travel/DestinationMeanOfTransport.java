package fr.ib.obodrel.travel;

import java.util.HashMap;

public class DestinationMeanOfTransport {
	private String _meanOfTransport;
	private String _meanName;
	private HashMap <String, String> _typesAllowed;

	public DestinationMeanOfTransport() {
		_typesAllowed = new HashMap<String, String>();

		_typesAllowed.put("p", "Plane");
		_typesAllowed.put("b", "Boat");
	}

	public boolean setMeanOfTransport(String newType) {
		if (_typesAllowed.containsKey(newType)) {
			_meanOfTransport = _typesAllowed.get(newType);
			return true;
		}
		return false;
	}

	public String getMeanOfTransport() {
		return _meanOfTransport;
	}

	public void setMeanName(String meanName) {
		_meanName = meanName;
	}

	public String getMeanName() {
		return _meanName;
	}

	public String toString() {
		String ret = "";

		ret += "Allowed means are : ";
		for (int i = 0; i < _typesAllowed.size(); i++) {
			if (_typesAllowed.keySet().toArray()[i].equals("q")) {
				continue;
			}
			ret += "\"" + _typesAllowed.keySet().toArray()[i];
			ret += "\" for ";
			ret += _typesAllowed.values().toArray()[i];
			if(i != _typesAllowed.size()-1) {
				ret += ", ";
			}
		}

		return ret;
	}
}
