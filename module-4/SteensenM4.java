// Alisa Steensen
// M4

// This program is using a linked list to store 50,000 and 500,000 numbers. I am testing the time it takes first to iterate through the list and then using the get(index) method. 


/* After reviewing the results, iteration method is much faster than the get(index) method. The iteration for ths first list took 3,015,300 nanoseconds the second list took 6,3666,500 nanoseconds. Now when running the get(index) method for ths first list, it took 1,233,103,100 nanoseconds the the second list just crashes the program or takes an extremely long time to finally display results. I have learned that the Linked List is not good with the get(index) method because it is so slow. */

//Reference for iterator: Tehrani, K. (2024, April 16). Iterator vs forEach() in Java. Baeldung. https://www.baeldung.com/java-iterator-vs-foreach
// Reference for how to use nanoTime: ​Krishna, M. (2021, February 6). How to measure elapsed time in nanoseconds with Java? TutorialsPoint. ​https://www.tutorialspoint.com/how-to-measure-elapsed-time-in-nanoseconds-with-java


import java.util.Iterator;
import java.util.LinkedList;

public class SteensenM4 {

    public static LinkedList<Integer> fiftyThousandIntegers() {
        LinkedList<Integer> firstList = new LinkedList<>();
        
        for (int i = 0; i < 50000; i++) { // Loop to create 50,000 integers
            firstList.add(i + 1); // add 1-50,000 to the list
        }
        return firstList;
    }

    public static LinkedList<Integer> fiveHundredThousandIntegers() {
        LinkedList<Integer> secondList = new LinkedList<>();
        
        for (int i = 0; i < 500000; i++) { // Loop to create 500,000 integers
            secondList.add(i + 1); // add 1-500,000 to the list
        }
        return secondList;
    }

    public static void testProgramOne() {
        LinkedList<Integer> firstList = fiftyThousandIntegers();
        LinkedList<Integer> secondList = fiveHundredThousandIntegers();
    
        // Measure time to iterate through the first list
        long startTime = System.nanoTime();
        Iterator<Integer> iterator1 = firstList.iterator();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        long endTime = System.nanoTime();
        System.out.println("The time for the first list using iterate is: " + (endTime - startTime) + " nanoseconds.");

        // Measure time to iterate through the second list
        startTime = System.nanoTime();
        Iterator<Integer> iterator2 = secondList.iterator(); 
        while (iterator2.hasNext()) {
            iterator2.next(); // moving through each number
        }
        
        endTime = System.nanoTime();
        System.out.println("The time for the second list using iterate is: " + (endTime - startTime) + " nanoseconds.");
    }
    

    public static void testProgramTwo() {
        LinkedList<Integer> firstList = fiftyThousandIntegers();
        LinkedList<Integer> secondList = fiveHundredThousandIntegers();

        // Measure time with get(index) method
        long startTime2 = System.nanoTime(); // tracking time at start
        for (int i = 0; i < firstList.size(); i++) {
            firstList.get(i); // using get(index) method
        }
        long endTime2 = System.nanoTime(); // tracking time at end
        // print results of the time difference taken to run the list
        System.out.println("The time for the first list using get(index) is: " + (endTime2 - startTime2) + " nanoseconds.");

        // Measure time for the second list with the get(index) method
        long startTime3 = System.nanoTime();
        for (int i = 0; i < secondList.size(); i++) {
            secondList.get(i); // using get(index) method
        }
        long endTime3 = System.nanoTime();
        System.out.println("The time for the second list using get(index) is: " + (endTime3 - startTime3) + " nanoseconds.");
    }
    

    public static void main(String[] args) {
        testProgramOne(); // Call the test programs to execute the code
        testProgramTwo();
    }
}

