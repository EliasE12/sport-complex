package model;

// Class

public class SportField {

	// Attributes

	private String name;
	private double length;
	private double area;

	// Constructor

	public SportField(String n, double l, double a ) {
		name = n;
		length = l;
		area = a;
	}

	// Methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	
	
	
}
