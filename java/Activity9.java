//Activity 9: Array List
package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("Nimesh");
		myList.add("Ramesh");
		myList.add("Mahesh");
		
		myList.add(1,"Banana");
		myList.add(4,"Mango");
		
		System.out.println("Here is myList: ");
		for (String s:myList) {
			System.out.println(s);
		}
		
		System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Chicku is in list: " + myList.contains("Chicku"));
        System.out.println("Size of ArrayList: " + myList.size());
        
        System.out.println("Is Banana removed from the List now? " + myList.remove("Banana"));
        
        System.out.println("New Size of ArrayList: " + myList.size());
	}
}
