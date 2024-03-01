
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int PERCENT = 100;
        final int MONTHS_IN_YEAR = 12;
        double principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Principal: ");
            principal = scanner.nextDouble();
            if (principal > 1_000 && principal < 1_000_000)
                break;
            System.out.println("Enter amount between $1,000 and $1,000,000");
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Annual Interest rate: ");
            float interestRate = scanner.nextFloat();
            if (interestRate > 0 && interestRate <= 30) {
                monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 but less than or equal to 30");
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Period: ");
            int period = scanner.nextInt();
            if (period > 1 && period < 30) {
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a number between 1 and 30");
        }

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments)- 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}