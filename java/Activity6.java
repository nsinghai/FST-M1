//Activity 6: implementation of Encapsulation
package activities;

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		
	Plane plane  = new Plane(10);
	plane.onboard("Nimesh");
	plane.onboard("Suresh");
	plane.onboard("Mahesh");
	plane.onboard("Ramesh");
	plane.onboard("Mukesh");
	
	System.out.println("Take-Off Time: " + plane.takeOff());
	System.out.println("List of Onboarded Passengers: " + plane.getPassengers());
	Thread.sleep(5000);
	plane.land();
	System.out.println("Plane is Landing now...");
	System.out.println("Landing Time: " + plane.getLastTimeLanded());
	System.out.println("Number of People after landing: " + plane.getPassengers());		
	}
}
