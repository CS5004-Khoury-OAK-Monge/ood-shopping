import java.util.Scanner;

/**
 * Sample program to demonstrate exceptions and exception handling.
 */
public class ExceptionsExample {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int dividend, divisor, quotient;

        System.out.println("Let's divide two integer numbers!");
        System.out.print("Dividend = ");
        dividend = userInput.nextInt();
        System.out.print("Divisor  = ");
        divisor = userInput.nextInt();

        quotient = dividend / divisor;

        System.out.printf("%d / %d = %d\n", dividend, divisor, quotient);
    }
}
