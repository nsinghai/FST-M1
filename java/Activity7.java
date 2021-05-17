//Activity 7: Hybrid Inheritance
package activities;

public class Activity7 {

	public static void main(String[] args) {
		MountainBike mB = new MountainBike(4,0,15);
		System.out.println("MountainBike Description: " + mB.bicycleDesc());
		System.out.print("Current Speed: " + mB.currentSpeed);
		mB.speedUp(20);
		mB.applyBrake(5);
		}

}

interface BicycleParts{
	public int gears = 0;
	public int currentSpeed = 0;
}

interface BicycleOperations{
	public void applyBrake(int decrement);
	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {
	public int gears;
	public int currentSpeed;
	
	public Bicycle(int gears, int currentSpeed){
				this.gears = gears;
				this.currentSpeed = currentSpeed;
	}
	public void applyBrake(int decrement) {
		currentSpeed -= decrement;
		System.out.println("\nCurrent Speed: " + currentSpeed);
	}
	
	public void speedUp(int increment) {
		currentSpeed += increment;
		System.out.println("\nCurrent speed: " + currentSpeed);
	}
	
	public String bicycleDesc() {
		return("\nNo of gears are: " + gears + "\nSpeed of bicycle: " + currentSpeed);
	}
}

class MountainBike extends Bicycle {

	public int seatHeight;
	public MountainBike(int gears, int currentSpeed, int startHeight) {
		super(gears, currentSpeed);
		seatHeight = startHeight;
	}
	
	public void setHeight(int newValue) {
		seatHeight = newValue;
	}
	
	public String bicycleDesc() {
		return(super.bicycleDesc() + "\nSeat height: " + seatHeight);
	}
}
