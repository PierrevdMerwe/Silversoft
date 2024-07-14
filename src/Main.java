import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = getPositiveInteger("Enter a positive integer for the number of rows: ");
        char symbol = getSymbol("Enter a character/symbol (press Enter for default '*'): ");

        printPattern(rows, symbol);
    }

    /**
     * Prompts the user to enter a positive integer and validates the input.
     * It will continue to ask until a valid positive integer is provided.
     *
     * @param prompt The message that will display asking for user input.
     * @return A positive integer entered by the user.
     */
    private static int getPositiveInteger(String prompt) {
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);

            // Error handle user input
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num > 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive number."); // Negative number entered
                }
            } else {
                System.out.println("That's not a valid number. Please try again."); // Other character entered that is not a number
                scanner.next();
            }
        }
        scanner.nextLine();
        return num;
    }

    /**
     * Prompts the user to enter a character/symbol to be used for the pattern.
     * If no input is provided, it defaults to '*'.
     *
     * @param prompt The message that will display asking for user input.
     * @return The chosen character/symbol of the user's input, or '*' if the input is empty.
     */
    private static char getSymbol(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim(); // Strip whitespace
        if (input.isEmpty()) {
            return '*'; // Default
        } else {
            System.out.println("More than one character/symbol has been entered, the chosen character/symbol is: " + input);
            return input.charAt(0); // Error handle user input if they entered more than one character
        }
    }

    /**
     * Prints the pattern using the specified number of rows with characters/symbols.
     *
     * @param rows The number of rows.
     * @param symbol The character/symbol to use for printing the pattern.
     */
    private static void printPattern(int rows, char symbol) {
        System.out.println("Output:");
        System.out.println();

        // Descending order
        for (int i = rows; i > 0; i--) {
            printLine(i, symbol);
        }

        System.out.println("----");

        // Ascending order
        for (int i = 1; i <= rows; i++) {
            printLine(i, symbol);
        }
    }

    /**
     * Prints a single line of the pattern with the specified number of symbols for the row.
     *
     * @param count The number of symbols to print in the row.
     * @param symbol The character/symbol to print.
     */
    private static void printLine(int count, char symbol) {
        for (int i = 0; i < count; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}