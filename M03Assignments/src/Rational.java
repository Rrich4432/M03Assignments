import java.math.BigInteger;
import java.util.Scanner;

public class Rational {
    private BigInteger numerator;
    private BigInteger denominator;

    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE); // Default to 0
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
        if (this.denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }
    }

    public Rational add(Rational other) {
        BigInteger newNumerator = numerator.multiply(other.denominator).add(other.numerator.multiply(denominator));
        BigInteger newDenominator = denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational other) {
        BigInteger newNumerator = numerator.multiply(other.denominator).subtract(other.numerator.multiply(denominator));
        BigInteger newDenominator = denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    public Rational multiply(Rational other) {
        BigInteger newNumerator = numerator.multiply(other.numerator);
        BigInteger newDenominator = denominator.multiply(other.denominator);
        return new Rational(newNumerator, newDenominator);
    }

    public Rational divide(Rational other) {
        BigInteger newNumerator = numerator.multiply(other.denominator);
        BigInteger newDenominator = denominator.multiply(other.numerator);
        return new Rational(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first rational number (numerator denominator): ");
        BigInteger num1 = input.nextBigInteger();
        BigInteger den1 = input.nextBigInteger();
        Rational rational1 = new Rational(num1, den1);

        System.out.print("Enter the second rational number (numerator denominator): ");
        BigInteger num2 = input.nextBigInteger();
        BigInteger den2 = input.nextBigInteger();
        Rational rational2 = new Rational(num2, den2);

        System.out.println(rational1 + " + " + rational2 + " = " + rational1.add(rational2));
        System.out.println(rational1 + " - " + rational2 + " = " + rational1.subtract(rational2));
        System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2));
        System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2));
        System.out.println(rational2 + " is " + rational2.numerator.doubleValue() / rational2.denominator.doubleValue());
    }
}
