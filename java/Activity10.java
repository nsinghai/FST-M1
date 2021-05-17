//Activity10: HashSet
package activities;

import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("Nimesh");
		hs.add("Ramesh");
		hs.add("Mahesh");
		hs.add("Suresh");
		hs.add("Rajesh");
		hs.add("Brajesh");
		
		System.out.println("Here is the initial list: " + hs);
		hs.remove("Rajesh");
		System.out.println("Here is the current list: " + hs);
		System.out.println("Does the list contains Nimesh? " + hs.contains("Nimesh"));
		System.out.println("Is the list empty?" + hs.isEmpty());
		System.out.println("Size of list: " + hs.size());
		if (hs.remove("Rajesh"))
		{
			System.out.println("Rajesh has been removed from the List");
		}
		else {
			System.out.println("Rajesh is not present in the List");
		}
		
	}

}
