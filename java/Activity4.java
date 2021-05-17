//Activity 4: Insertion Sort algorithm
package activities;

import java.util.Arrays;

class Activity4 {
    static void ascendingSort(int array[]) {
        int size = array.length;
        int i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
    
    public static void main(String args[]) {
        int[] data = { 12, 3, 9, 1, 6 };
        System.out.println("Given Array: " + Arrays.toString(data));
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));
        }
}
