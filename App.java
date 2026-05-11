/*******************************************************************
* Name: Dennis Franks Jr
* Date: 05/02/2026
* Assignment: Final Calculator Project - Application Delivery
*
* This final calculator application combines user interaction,
* methods, collections, memory functions, and exception handling.
*******************************************************************/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static double singleMemory = 0;
    private static boolean hasSingleMemory = false;
    private static ArrayList<Integer> numberMemory = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("Dennis Franks Jr - Final Calculator Project");
        System.out.println();

        System.out.println("Welcome to the Final Calculator Application.");
        System.out.println("This program performs basic calculations, uses memory functions,");
        System.out.println("stores integer values, and handles input errors.");
        System.out.println();

        do {
            displayMenu();

            try {
                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        addNumbers(input);
                        break;
                    case 2:
                        subtractNumbers(input);
                        break;
                    case 3:
                        multiplyNumbers(input);
                        break;
                    case 4:
                        divideNumbers(input);
                        break;
                    case 5:
                        storeSingleValue(input);
                        break;
                    case 6:
                        retrieveSingleValue();
                        break;
                    case 7:
                        clearSingleValue();
                        break;
                    case 8:
                        replaceSingleValue(input);
                        break;
                    case 9:
                        addIntegerValue(input);
                        break;
                    case 10:
                        displayIntegerValues();
                        break;
                    case 11:
                        displayCount();
                        break;
                    case 12:
                        removeIntegerValue(input);
                        break;
                    case 13:
                        displaySum();
                        break;
                    case 14:
                        displayAverage();
                        break;
                    case 15:
                        displayDifference();
                        break;
                    case 16:
                        System.out.println("Thank you for using the Final Calculator Application.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid menu option.");
                }

            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Invalid input. Please enter numbers only.");
                input.nextLine();
            }

            System.out.println();

        } while (choice != 16);

        input.close();
    }

    public static void displayMenu() {
        System.out.println("Calculator Menu");
        System.out.println("1. Add two numbers");
        System.out.println("2. Subtract two numbers");
        System.out.println("3. Multiply two numbers");
        System.out.println("4. Divide two numbers");
        System.out.println("5. Store a single numeric value in memory");
        System.out.println("6. Retrieve the single memory value");
        System.out.println("7. Clear the single memory value");
        System.out.println("8. Replace the single memory value");
        System.out.println("9. Add an integer value to collection memory");
        System.out.println("10. Display all integer values stored");
        System.out.println("11. Display count of integer values stored");
        System.out.println("12. Remove an integer value from collection memory");
        System.out.println("13. Get sum of integer values");
        System.out.println("14. Get average of integer values");
        System.out.println("15. Get difference of first and last values");
        System.out.println("16. Quit");
    }

    public static void addNumbers(Scanner input) {
        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        System.out.printf("Result: %.2f + %.2f = %.2f%n", num1, num2, num1 + num2);
    }

    public static void subtractNumbers(Scanner input) {
        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        System.out.printf("Result: %.2f - %.2f = %.2f%n", num1, num2, num1 - num2);
    }

    public static void multiplyNumbers(Scanner input) {
        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        System.out.printf("Result: %.2f * %.2f = %.2f%n", num1, num2, num1 * num2);
    }

    public static void divideNumbers(Scanner input) {
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print("Enter the first number: ");
                double num1 = input.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = input.nextDouble();

                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }

                System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, num1 / num2);
                valid = true;

            } catch (ArithmeticException e) {
                System.out.println(e);
                System.out.println("The second number cannot be zero. Please try again.");
            }
        }
    }

    public static void storeSingleValue(Scanner input) {
        System.out.print("Enter a numeric value to store in memory: ");
        singleMemory = input.nextDouble();
        hasSingleMemory = true;
        System.out.println("Value stored in memory.");
    }

    public static void retrieveSingleValue() {
        if (hasSingleMemory) {
            System.out.println("Single memory value: " + singleMemory);
        } else {
            System.out.println("No single memory value has been stored.");
        }
    }

    public static void clearSingleValue() {
        singleMemory = 0;
        hasSingleMemory = false;
        System.out.println("Single memory value cleared.");
    }

    public static void replaceSingleValue(Scanner input) {
        System.out.print("Enter the replacement numeric value: ");
        singleMemory = input.nextDouble();
        hasSingleMemory = true;
        System.out.println("Single memory value replaced.");
    }

    public static void addIntegerValue(Scanner input) {
        if (numberMemory.size() >= 10) {
            System.out.println("The collection already has 10 values. No more can be added.");
            return;
        }

        System.out.print("Enter an integer value to add: ");
        int value = input.nextInt();
        numberMemory.add(value);
        System.out.println("Integer value added.");
    }

    public static void displayIntegerValues() {
        if (numberMemory.size() == 0) {
            System.out.println("No integer values are currently stored.");
            return;
        }

        System.out.println("Integer values stored:");
        for (int i = 0; i < numberMemory.size(); i++) {
            System.out.println("Index " + i + ": " + numberMemory.get(i));
        }
    }

    public static void displayCount() {
        System.out.println("Count of integer values stored: " + numberMemory.size());
    }

    public static void removeIntegerValue(Scanner input) {
        if (numberMemory.size() == 0) {
            System.out.println("No values are available to remove.");
            return;
        }

        displayIntegerValues();
        System.out.print("Enter the index of the value to remove: ");
        int index = input.nextInt();

        if (index >= 0 && index < numberMemory.size()) {
            int removedValue = numberMemory.remove(index);
            System.out.println("Removed value: " + removedValue);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void displaySum() {
        if (numberMemory.size() == 0) {
            System.out.println("No values are available to total.");
            return;
        }

        int sum = 0;

        for (int value : numberMemory) {
            sum += value;
        }

        System.out.println("Sum of integer values: " + sum);
    }

    public static void displayAverage() {
        if (numberMemory.size() == 0) {
            System.out.println("No values are available to average.");
            return;
        }

        int sum = 0;

        for (int value : numberMemory) {
            sum += value;
        }

        double average = (double) sum / numberMemory.size();

        System.out.printf("Average of integer values: %.2f%n", average);
    }

    public static void displayDifference() {
        if (numberMemory.size() < 2) {
            System.out.println("At least two values are needed to calculate the difference.");
            return;
        }

        int first = numberMemory.get(0);
        int last = numberMemory.get(numberMemory.size() - 1);

        System.out.println("Difference of first and last values: " + (first - last));
    }
}