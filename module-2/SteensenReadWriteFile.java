// Alisa Steensen
// Module 2

/* A simple program that initiates an array with 5 random integers and 5 random doubles. Writes the numbers to the file or appends. Then prints the numbers from the file*/

// Reference help https://www.tutorialspoint.com/generate-a-random-array-of-integers-in-java
// https://www.tutorialspoint.com/java-program-to-write-int-array-to-a-file
// https://www.geeksforgeeks.org/arrays-in-java/#
// https://www.w3schools.com/java/java_files_create.asp
// https://www.w3schools.com/java/java_files_read.asp

// importing classes
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SteensenReadWriteFile {
    public static void main(String[] args) {
        
        String fileName = "Steensendatafile.dat"; // store filename as Lastnamedatafile.dat

        writeTheFile(fileName); // calling the writeTheFile method
        readTheFile(fileName); // calling the readTheFile method

    }
        
        public static void writeTheFile(String fileName) {
        
            try {
                FileWriter writer = new FileWriter(fileName, true); // write to file and append if already written to
                Random random = new Random();
                int intArray[] = new int[5]; // create an array of 5 integers
                double doubleArray[] = new double[5]; // create an array of 5 doubles
                
                for (int i = 0; i <intArray.length; i++) { // Looping through the array and writing random integers to the file
                    intArray[i] = random.nextInt();
                    writer.write("Random Integers: " + intArray[i] + "\n");
                }
                for (int i = 0; i <doubleArray.length; i++) { // Looping through the array and writing random doubles to the file
                    doubleArray[i] = random.nextDouble();
                    writer.write("Random Doubles: " + doubleArray[i] + "\n");
                    
                } System.out.println("Data has been written to: " + fileName);
                writer.close(); // make sure to close the writer when finished
                } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
       }
    }
       
    // Reading the file method and display the contents
    public static void readTheFile(String fileName) {
        try {
            File newFile = new File(fileName); 
            Scanner myReader = new Scanner(newFile);
            while (myReader.hasNextLine()) { // To continue reading each line until the end of the file
                String numbers = myReader.nextLine(); // read the next line
                System.out.println(numbers); // printing out each of the random numbers
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 

    
    }
}