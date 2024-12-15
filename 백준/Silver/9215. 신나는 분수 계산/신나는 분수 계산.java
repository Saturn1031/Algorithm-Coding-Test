import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCount = 0;

        while(true) {
            int answerW = 0;
            int answerN = 0;
            int answerD = 1;

            int count = in.nextInt();
            in.nextLine();

            if (count == 0) {
                System.exit(0);
            }

            for (int i = 1; i <= count; i++) {
                String inputNum = in.nextLine();

                if (inputNum.contains(",")) {
                    int integerPart = Integer.parseInt(inputNum.split(",")[0]);
                    answerW += integerPart;

                    String fraction = inputNum.split(",")[1];

                    int Npart = Integer.parseInt(fraction.split("/")[0]);
                    int Dpart = Integer.parseInt(fraction.split("/")[1]);

                    answerN = answerN * Dpart + Npart * answerD;
                    answerD = answerD * Dpart;

                    if (answerN >= answerD) {
                        answerN -= answerD;
                        answerW++;
                    }

                    BigInteger answerNBigInteger = BigInteger.valueOf(answerN);
                    BigInteger answerDBigInteger = BigInteger.valueOf(answerD);
                    BigInteger gcd = answerNBigInteger.gcd(answerDBigInteger);

                    if (!gcd.equals(BigInteger.ONE)) {
                        answerNBigInteger = answerNBigInteger.divide(gcd);
                        answerDBigInteger = answerDBigInteger.divide(gcd);

                        answerN = answerNBigInteger.intValue();
                        answerD = answerDBigInteger.intValue();
                    }
                } else if (inputNum.contains("/")) {
                    int Npart = Integer.parseInt(inputNum.split("/")[0]);
                    int Dpart = Integer.parseInt(inputNum.split("/")[1]);

                    answerN = answerN * Dpart + Npart * answerD;
                    answerD = answerD * Dpart;

                    if (answerN >= answerD) {
                        answerN -= answerD;
                        answerW++;
                    }

                    BigInteger answerNBigInteger = BigInteger.valueOf(answerN);
                    BigInteger answerDBigInteger = BigInteger.valueOf(answerD);
                    BigInteger gcd = answerNBigInteger.gcd(answerDBigInteger);

                    if (!gcd.equals(BigInteger.ONE)) {
                        answerNBigInteger = answerNBigInteger.divide(gcd);
                        answerDBigInteger = answerDBigInteger.divide(gcd);

                        answerN = answerNBigInteger.intValue();
                        answerD = answerDBigInteger.intValue();
                    }
                } else {
                    answerW += Integer.parseInt(inputNum);
                }
            }

            testCount++;

            if (answerW == 0) {
                if (answerN == 0) {
                    System.out.printf("Test %d: 0\n", testCount);
                } else {
                    System.out.printf("Test %d: %d/%d\n", testCount, answerN, answerD);
                }
            } else {
                if (answerN == 0) {
                    System.out.printf("Test %d: %d\n", testCount, answerW);
                } else {
                    System.out.printf("Test %d: %d,%d/%d\n", testCount, answerW, answerN, answerD);
                }
            }
        }
    }
}
