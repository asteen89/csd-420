// Alisa Steensen
// Module 3.2

// Reference for help on removing duplicates: Scaler Topics. (n.d.). How to Remove Duplicates from Arraylist in Java? https://www.scaler.com/topics/remove-duplicates-from-arraylist/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SteensenArrayList {
    public static void main(String[] args) {
        
        ArrayList<Integer> randomList = new ArrayList<>();

        Random random = new Random();

        // Fill the list with random integers
        for (int i = 0; i < 50; i++) {
            randomList.add(random.nextInt(20) + 1); // Fill with random integers from 1 to 20
        }

        ArrayList<Integer> newList = removeDuplicates(randomList);

        System.out.println(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>(); // New list to store the new elements
        HashSet<E> uniqueSet = new HashSet<>(); // Using HashSet to keep track of unique elements only

        for (E element : list) {
            if (uniqueSet.add(element)) { // Adding elements to the HashSet
                newList.add(element); // When the number is unique, add it to the new list
            }
        }
        return newList;
    }
}

