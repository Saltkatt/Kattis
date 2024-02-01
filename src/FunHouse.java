import java.io.*;
import java.util.*;

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

/*

public class FunHouse {

    public static void main (String[] args){

        Kattio io = new Kattio(System.in, System.out);

        int houseNumber = 0;
        int width = 0;
        int length = 0;
        List<String> house = new ArrayList<>();
        List<String> listOfEverything = new ArrayList<>();


        while(io.hasMoreTokens()){
            houseNumber++;
            house.clear();

            if(io.equals("0 0")){
                break;
            }

            if(io.hasMoreTokens()){
                width = io.getInt();
            }
            if (io.hasMoreTokens()){
                length = io.getInt();
            }


            if(io.hasMoreTokens()){
                for(int i = 0; i < length; i++){
                    house.add(io.getWord());
                }

            }
            findEntrance(length, house, houseNumber);
        }

        System.exit(0);
        io.close();

    }



    public static void findEntrance(int length, List<String> house, int houseNumber){

        int entranceIndex = 0;
        int row = 0;

        for(int i = 0; i < length; i++){

            if(house.get(i).contains("*")){
                entranceIndex = house.get(i).indexOf("*");
                row = i;
                checkForAmpersand(house);

                if(row == 0){
                    goDown(house, row, entranceIndex, houseNumber);

                }
                if(row == length - 1){
                    goUp(house, row, entranceIndex, houseNumber);

                }
                if(row > 0 || row < length - 1){

                    if(entranceIndex > 0){
                        goLeft(house, row, entranceIndex, houseNumber);
                    }
                    else{
                        goRight(house, row, entranceIndex, houseNumber);
                    }

                }
            }
        }

    }

    public static void goDown(List<String> house, int row, int index, int houseNumber){

        int newRow = row + 1;
        char charAtCurrentPosition = house.get(newRow).charAt(index);


        switch (charAtCurrentPosition){
            case '/':
                goLeft(house, newRow, index, houseNumber);
                break;
            case '\\':
                goRight(house, newRow, index, houseNumber);
                break;
            case '.':
                goDown(house, newRow, index, houseNumber);
                break;
            case 'x':
                addExitToHouse(house, newRow, index, houseNumber);
                break;

        }

    }

    private static void goRight(List<String> house, int row, int index, int houseNumber) {
        int newIndex = index + 1;
        char charAtCurrentPosition = house.get(row).charAt(newIndex);


        switch (charAtCurrentPosition){
            case '/':
                goUp(house, row, newIndex, houseNumber);
                break;
            case '\\':
                goDown(house, row, newIndex, houseNumber);
                break;
            case '.':
                goRight(house, row, newIndex, houseNumber);
                break;
            case 'x':
                addExitToHouse(house, row, newIndex, houseNumber);
                break;

        }
    }

    private static void goLeft(List<String> house, int row, int index, int houseNumber) {

        int newIndex = index - 1;
        char charAtCurrentPosition = house.get(row).charAt(newIndex);


        switch (charAtCurrentPosition){
            case '/':
                goDown(house, row, newIndex, houseNumber);
                break;
            case '\\':
                goUp(house, row, newIndex, houseNumber);
                break;
            case '.':
                goLeft(house, row, newIndex, houseNumber);
                break;
            case 'x':
                addExitToHouse(house, row, newIndex, houseNumber);
                break;

        }
    }

    private static void goUp(List<String> house, int row, int index, int houseNumber) {

        int newRow = row - 1;
        char charAtCurrentPosition = house.get(newRow).charAt(index);


        switch (charAtCurrentPosition){
            case '/':
                goRight(house, newRow, index, houseNumber);
                break;
            case '\\':
                goLeft(house, newRow, index, houseNumber);
                break;
            case '.':
                goUp(house, newRow, index, houseNumber);
                break;
            case 'x':
                addExitToHouse(house, newRow, index, houseNumber);
                break;

        }

    }

    public static boolean checkForAmpersand(List<String> house){

        for (int i = 0; i < house.size(); i++){
            if(house.get(i).contains("&")){
                return true;
            }
        }
        return false;

    }

    public static void addExitToHouse(List<String> house, int row, int index, int houseNumber){

        char exit = '&';
        String houseRow = house.get(row);
        String houseExit = "";
        if(checkForAmpersand(house) == true){
            return;
        }

        StringBuilder sb = new StringBuilder(houseRow);
        sb.setCharAt(index, exit);

        houseExit = sb.toString();

        house.set(row, houseExit);

        System.out.println("HOUSE " + houseNumber);
        for (int i = 0; i < house.size(); i++){
            System.out.println(house.get(i));
        }

    }
}
*/
