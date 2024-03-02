
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double principal = principal(0.0);

        float monthlyInterest = annualInterestRate(0.0f);

        int numberOfPayments = period(0);

        double mortgage = calculatedMortgage(principal, monthlyInterest, numberOfPayments);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double principal(double p) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Principal: ");
            p = scanner.nextDouble();
            if (p > 1_000 && p < 1_000_000)
                break;
            System.out.println("Enter amount between $1,000 and $1,000,000");
        }
        return p;
    }

    public static float annualInterestRate(float i) {
        Scanner scanner = new Scanner(System.in);
        final int PERCENT = 100;
        final int MONTHS_IN_YEAR = 12;
        float m;
        while (true) {
            System.out.print("Annual Interest rate: ");
            i = scanner.nextFloat();
            if (i > 0 && i <= 30) {
                m = i / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 but less than or equal to 30");
        }
        return m;
    }

    public static int period(int p) {
        final int MONTHS_IN_YEAR = 12;
        int n;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Period: ");
            p = scanner.nextInt();
            if (p > 1 && p < 30) {
                n = p * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a number between 1 and 30");
        }
        return n;
    }

    public static double calculatedMortgage(double p, float m, int n) {
        return p
                * (m * Math.pow(1 + m, n))
                / (Math.pow(1 + m, n)- 1);
    }
}