import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class SteensenTest {
    public static void main(String[] args) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter("SteensenTest.dat", true));
            Random random = new Random();
            int[] integerArray = new int[5];
            double[] doubleArray = new double[5];

            for (int i = 0; i < integerArray.length; i++) { // Looping through the array and writing random integers to the file
                integerArray[i] = random.nextInt();
                file.println("Random Integers: " + integerArray[i]);
            }
            for (int i = 0; i < doubleArray.length; i++) { // Looping through the array and writing random doubles to the file
                doubleArray[i] = random.nextDouble();
                file.println("Random Doubles: " + doubleArray[i]);
            }
            file.close();
        } catch (Exception e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }

        readTheFile("SteensenTest.dat");
    }

    public static void readTheFile(String fileName) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) { // read each line till the end of the file
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error occurred."); // more errors incase
            e.printStackTrace();
        }
        
    }
}