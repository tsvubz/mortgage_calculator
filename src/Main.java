
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int PERCENT = 100;
        final int MONTHS_IN_YEAR = 12;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Annual Interest rate: ");
        float interestRate = scanner.nextFloat();
        float monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period: ");
        int period = scanner.nextInt();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments)- 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}