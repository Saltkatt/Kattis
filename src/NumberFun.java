import java.io.*;
import java.util.StringTokenizer;
import java.lang.Math.*;

/*class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}*/
public class NumberFun {

    public static void main (String[] args) {

        Kattio io = new Kattio(System.in, System.out);

        int i = 0;
        int numberOfInput = 0;
        int a = 0;
        int b = 0;
        int sum = 0;

        if (io.hasMoreTokens())
            numberOfInput = io.getInt();

        for (i = 0; i < numberOfInput; i++) {

            if(io.hasMoreTokens()){
                a = io.getInt();
            }

            if(io.hasMoreTokens()){
                b = io.getInt();
            }

            if(io.hasMoreTokens()){
                sum = io.getInt();
            }

            System.out.println(checkOperationsEqualsSum(a, b, sum));

        }


    }
    public static String checkOperationsEqualsSum(int a, int b, int sum){

        String impossible = "Impossible";
        String possible = "Possible";

        if(checkOperationAddEqualsSum(a, b, sum)){
            return possible;
        }
        else if(checkOperationSubtractEqualsSum(a, b, sum)){
            return possible;
        }
        else if(checkOperationMultiplicationEqualsSum(a, b, sum)){
            return possible;
        }
        else if(checkOperationDivisionEqualsSum(a, b, sum)){
            return possible;
        }

        return impossible;

    }

    public static boolean checkOperationAddEqualsSum(int a, int b, int sum){

       boolean equalsSum = false;

        if(sum == a + b ){
            equalsSum = true;
        }

        return equalsSum;

    }

    public static boolean checkOperationSubtractEqualsSum(int a, int b, int sum){

        boolean equalsSum = false;

        if(sum == a - b || sum == b - a){
            equalsSum = true;
        }

        return equalsSum;

    }

    public static boolean checkOperationMultiplicationEqualsSum(int a, int b, int sum){

        boolean equalsSum = false;

        if(sum == a * b){
            equalsSum = true;
        }

        return equalsSum;

    }

    public static boolean checkOperationDivisionEqualsSum(double a, double b, int sum){

        boolean equalsSum = false;
        double fraction1;
        double fraction2;
        fraction1 = a / b;
        fraction2 = b / a;

        if(fraction1 == sum || fraction2 == sum){
            equalsSum = true;
        }

        return equalsSum;

    }


}
