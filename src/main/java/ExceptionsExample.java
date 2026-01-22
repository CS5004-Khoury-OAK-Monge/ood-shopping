import java.util.Scanner;

/**
 * Sample program to demonstrate exceptions and exception handling.
 */
public class ExceptionsExample {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int dividend, divisor, quotient;

        try { // "the code might throw an exception"
            System.out.println("Let's divide two integer numbers!");
            System.out.print("Dividend = ");
            dividend = userInput.nextInt();
            System.out.print("Divisor  = ");
            divisor = userInput.nextInt();
        } catch(Exception e) { // exception handler... "catches the exception"
            System.out.println("Please enter an integer for this program to work correctly");
            dividend = 0;
            divisor = 1;
            System.out.printf("The program will now use %d for divided and %d for divisor\n",
                    dividend, divisor);
        }
        quotient = dividend / divisor;

        System.out.printf("%d / %d = %d\n", dividend, divisor, quotient);

        System.out.println("Enter an index to retrieve the appropriate argument: ");
        int index = userInput.nextInt();
        String argument = args[index];
        System.out.printf("The argument at index %d is %s", index, argument);
    }
}
