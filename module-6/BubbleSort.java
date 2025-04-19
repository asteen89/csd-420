// Alisa Steensen
// Module 6.2

// This program uses the bubble sort to sort through the elements based on the comparable and comparator. The comparable will sort by name and the comparator will sort by age. It will print the original list then print the new lists in sorted order.

// Reference for bubble sorting sorting with strings: Vultr. (2024, December 20). Java program to implement bubble sort algorithm. Vultr Docs. https://docs.vultr.com/java/examples/implement-bubble-sort-algorithm
// Youcademy. (n.d.). Implementation of Bubble Sort Algorithm in Java. Youcademy. Retrieved April 17, 2025, from https://youcademy.org/bubble-sort-java/

import java.util.ArrayList;
import java.util.Comparator;

// Create the BubbleSort class
public class BubbleSort {
    
    // Bubble sort method using Comparable to sort by name
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        for (int k = 0; k < list.length; k++) {
            for (int i = 0; i < list.length - 1 - k; i++) {
                // using compareTo to compare each name and swap
                if (list[i].compareTo(list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }

    // Bubble sort method using Comparator to sort by age
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int k = 0; k < list.length; k++) {
            for (int i = 0; i < list.length - 1 - k; i++) {
                // Using comparator to compare each age and swap
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
    }

    // Static helper class to compare ages
    public static class PersonAgeComparator implements Comparator<People> {
        @Override
        public int compare(People person1, People person2) {
            return person1.getAge().compareTo(person2.getAge());
        }
    }

    public static void main(String[] args) {
        // New ArrayList of people to store names and ages
        ArrayList<People> list = new ArrayList<>();
        list.add(new People("Alisa", 36));
        list.add(new People("Skylar", 12));
        list.add(new People("Spencer", 10));
        list.add(new People("Sawyer", 5));
        list.add(new People("Stryker", 3));

        // Print original list without sorting
        System.out.println("Before sorting:");
        for (People person : list) { 
            System.out.println(person);
        }

        // Make ArrayList into an array to be sorted
        People[] array = new People[list.size()];
        list.toArray(array);

        // Sort by age using Comparator
        bubbleSort(array, new PersonAgeComparator());
        System.out.println("\nAfter sorting by age with comparator:");
        for (People person : array) {
            System.out.println(person);
        }

        // Sort by name using Comparable
        bubbleSort(array);
        System.out.println("\nAfter sorting by name with comparable:");
        for (People person : array) {
            System.out.println(person);
        }
    }
}

// Class for people that implements Comparable
class People implements Comparable<People> {

    public String name;
    public int age;

    public String getName() {
        return name;
    }
    // wrapper method to get age and turn it into an Integer object
    public Integer getAge() {
        return age;
    }

    People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Comparable method to sort by name
    @Override
    public int compareTo(People other) {
        return this.name.compareTo(other.name);
    }

    // toString method to print the name and age of the Person
    @Override
    public String toString() {
        return name + ": " + age;
    }
}
