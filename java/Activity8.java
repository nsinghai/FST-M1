//Activity 8: custom Exception handler
package activities;

public class Activity8 {
    public static void main(String[] arg){
        try {
            // Method call with correct input
            Activity8.exceptionTest("Will print to console");
            // Method call with incorrect input
            Activity8.exceptionTest(null); // Exception is thrown here
            Activity8.exceptionTest("This line will not be executed");
        } catch(CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }
    }
    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
}