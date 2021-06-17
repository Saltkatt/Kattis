import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class anewalphabet {
    public static void main(String[] args)
    {
        final Map<Character, String> map;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();

        /*HashMap<String , String> map = new HashMap<>();
        String[] lett = new String[26];
        String[] alph = {"@","8","(","|)","3","#","6","[-]","|","_|","|<","1","[]\\/[]","[]\\[]","0","|D","(,)","|Z","$","']['","|_|","\\/","\\/\\/","}{","`/","2"};

        for (int i = 0; i < lett.length; i++)
            lett[i] = "" + (char)(i + 97);

        for (int i = 0; i < alph.length; i++)
            map.put(lett[i], alph[i]);*/


        map = new HashMap<>();
        map.put('a', "@");
        map.put('b', "8");
        map.put('c', "(");
        map.put('d', "|)");
        map.put('e', "3");
        map.put('f', "#");
        map.put('g', "6");
        map.put('h', "[-]");
        map.put('i', "|");
        map.put('j', "_|");
        map.put('k', "|<");
        map.put('l', "1");
        map.put('m', "[]\\/[]");
        map.put('n', "[]\\[]");
        map.put('o', "0");
        map.put('p', "|D");
        map.put('q', "(,)");
        map.put('r', "|Z");
        map.put('s', "$");
        map.put('t', "']['");
        map.put('u', "|_|");
        map.put('v', "\\/");
        map.put('w', "\\/\\/");
        map.put('x', "}{");
        map.put('y', "`/");
        map.put('z', "2");

        String build = "";

        for(final char c : str.toCharArray()){
            final String val;
            val = map.get(c);

            if( val == null ){
                build += c;
            }
            else{
                build += val;
            }
        }
        System.out.println(build);
        sc.close();
    }
}
