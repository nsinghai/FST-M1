package activities;

public class Activity1 {

	public static void main(String[] args) {

	Car BMW = new Car();
	BMW.make = 2014;
	BMW.color = "Black";
	BMW.transmission = "Manual";
	
	BMW.displayCharacteristics();
	BMW.accelerate();
	BMW.brake();
	}
}
