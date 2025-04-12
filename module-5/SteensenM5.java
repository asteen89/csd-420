// Alisa Steensen
// M5

/*This program imports words from a file and places them into a HashSet first to remove the duplicates. Then using TreeSet to sort the words in ascending order
first to print, finally using the descendingSet method to print the words in descending order. The program will print both lists to the console.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SteensenM5 {
    public static void main(String[] args) {
        try (Scanner myReader = new Scanner(new File("collection_of_words.txt"))) { // Setting up Try-with resources

            HashSet<String> hashSetList = new HashSet<>(); // Setting up and using Hashset to remove duplicates
            while (myReader.hasNextLine()) {
                hashSetList.add(myReader.next()); // Reading the file and adding words to the HashSet
            }
            TreeSet<String> treeSetList = new TreeSet<>(hashSetList); //Using TreeSet to sort the words

            System.out.println("Words in ascending order without duplicates:");
            // Using foreach loop to print the words in ascending order with TreeSet
            for (String words : treeSetList) {
                System.out.println(words);
            }

            System.out.println("\nWords in descending order without duplicates:");
            // Using foreach loop to print the words in descending order using descendingSet method
            for (String words : treeSetList.descendingSet()) {
                System.out.println(words);
            }

        } catch (FileNotFoundException e) { 
            System.out.println("File not found.");
        }
    }
}