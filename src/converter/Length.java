package converter;

public enum Length {
	METER(1.0),
	CENTIMETER(0.01),
	KILOMETER(1000),
	MILE(1609.344),
	FOOT(0.3048),
	WA(2.0),
	AU(149597870700.0);
	
	
	// attributes of the enum members
	private final double value;
	
	// constructor must be private
	private Length(double value) { this.value = value; }
	// methods just like in a class
	public double getValue() { return this.value; }
}


