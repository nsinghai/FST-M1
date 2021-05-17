//Activity 11: HashMAP
package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Blue");
		hm.put(2, "Red");
		hm.put(3, "Green");
		hm.put(4, "Orange");
		hm.put(5, "White");
		
		System.out.println("Here is the initial Map: " + hm);
		
		hm.remove(4);
		System.out.println("Here is the updated Map: " + hm);
		
		if(hm.containsKey(3)) {
			System.out.println("Green colour is present in the Map");
		} else {
			System.out.println("Green colour is NOT present");
			}
		if(hm.containsValue("Orange")) {
			System.out.println("Orange colour is present in the Map");
		}
		else {
			System.out.println("Orange colour is NOT present");
		}
		System.out.println("Number of Pairs in the Map: " + hm.size());
	}
}
