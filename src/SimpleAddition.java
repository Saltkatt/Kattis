import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimpleAddition {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger firstNumber = new BigInteger("0");
        BigInteger secondNumber = new BigInteger("0");

            if(sc.hasNextLine()){
                firstNumber = sc.nextBigInteger();
            }
            if(sc.hasNextLine()){
                secondNumber = sc.nextBigInteger();
            }

        System.out.println(firstNumber.add(secondNumber));

        System.exit(0);

    }


}
