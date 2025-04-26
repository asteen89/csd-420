// Alisa Steensen
// Module 8.2

// This program has 3 threads that will generate random numbers, letters and symbols. I wanted the threads to be completed in order, so I used join so that the next thread would not start until the previous one was finished. I also used StringBuilder to keep track of how many letters were generated in each thread for testing. And finally I used runnable to create the threads and keep the code clean.

// Reference: Saanjaay. (2021, October 22). How to run multiple threads in a specific order in Java. Medium. https://saannjaay.medium.com/how-to-run-multiple-threads-in-a-specific-order-in-java-0bee3df498d7

import java.util.Random;

public class AlisaThreeThreads {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(); // Random to generate random letters, numbers and symbols

        // Thread 1 Random lowercase letters
        Runnable letterTask = new LetterTask(random);
        Thread thread1 = new Thread(letterTask);

        // Thread 2 Random numbers
        Runnable numberTask = new NumberTask(random);
        Thread thread2 = new Thread(numberTask);

        // Thread 3 Random symbols
        Runnable symbolTask = new SymbolTask(random);
        Thread thread3 = new Thread(symbolTask);

        thread1.start();
        thread1.join(); // Wait for thread1 to finish before starting the next one

        thread2.start();
        thread2.join(); // Wait for thread2 to finish

        thread3.start();
        thread3.join();
        
    }
}

// Thread 1 
class LetterTask implements Runnable {
    private final Random random; // Random to generate random letters

    public LetterTask(Random random) {
        this.random = random;
    }
    StringBuilder sb = new StringBuilder(); // For testing purposes, to keep track of how many letters were generated

    @Override
    public void run() { // Loop to generate 10,000 random letters
        for (int i = 0; i < 10000; i++) {
            char letters = (char) ('a' + random.nextInt(26));
            sb.append(letters);
            System.out.print(letters + " ");
        }
        System.out.println("\nThread 1 has " + sb.length() + " letters.");
        System.out.println();
    }
}

// Thread 2 
class NumberTask implements Runnable {
    private final Random random; // Random to generate random numbers

    public NumberTask(Random random) {
        this.random = random;
    }
    StringBuilder sb = new StringBuilder(); // For testing purposes, to keep track of how many numbers were generated

    @Override
    public void run() { // Loop to generate 10,000 random numbers
        for (int i = 0; i < 10000; i++) {
            int numbers = random.nextInt(10);
            sb.append(numbers);
            System.out.print(numbers + " ");
        }
        System.out.println("\nThread 2 has " + sb.length() + " numbers.");
        System.out.println();
    }
}


// Thread 3 
class SymbolTask implements Runnable {
    private final Random random;    // Random to generate random symbols
    private final char[] symbols = {'!', '@', '#', '$', '%', '&', '*'}; // Array of the symbols I need to generate
    private final StringBuilder sb = new StringBuilder(); 

    public SymbolTask(Random random) {
        this.random = random;
    }

    @Override
    public void run() { // Loop to generate 10,000 random symbols
        for (int i = 0; i < 10000; i++) {
            char symbol = symbols[random.nextInt(symbols.length)];
            sb.append(symbol);
            System.out.print(symbol + " ");
        }
        System.out.println("\nThread 3 has " + sb.length() + " symbols.");
        System.out.println();
    }
}
