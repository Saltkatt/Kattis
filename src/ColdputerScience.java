import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
class Kattio extends PrintWriter {
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
}
*/

public class ColdputerScience {

    public static void main (String[] args){

        Kattio io = new Kattio(System.in, System.out);

        int numberOfTemperatures = 0;
        List<Integer> temperatures = new ArrayList<>();


        if(io.hasMoreTokens()){
            numberOfTemperatures = io.getInt();
        }

        for(int i = 0; i < numberOfTemperatures; i++){
            if(io.hasMoreTokens()){
                temperatures.add(io.getInt());
            }
        }

        System.out.println(countNegativeTemperaturesInList(temperatures));

        io.close();

    }

    public static int countNegativeTemperaturesInList(List<Integer> temperatures){
        int negativeTempDays = 0;

        for(int i = 0; i < temperatures.size(); i++){
            if(temperatures.get(i) < 0){
                negativeTempDays++;
            }
        }
        //System.out.println("Negative days: " + negativeTempDays);
        return negativeTempDays;
    }

}
