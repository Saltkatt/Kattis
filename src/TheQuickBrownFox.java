import java.util.*;

public class TheQuickBrownFox {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";

        int numberOfStrings = 0;

        if(sc.hasNext()){
            numberOfStrings = sc.nextInt();

                for(int i = 0; i <= numberOfStrings; i++){

                    input = sc.nextLine();
                    if(!input.isEmpty()) {
                        checkStringContainsAllLetters(input);
                    }
                }
        }

        System.exit(0);

    }

    public static void checkStringContainsAllLetters(String input){

        long checkInput = input.toLowerCase().chars()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .distinct()
                .count();

        if(checkInput == 26){
            System.out.println("pangram");
        }
        else{
            findMissingLetters(input);
        }

    }

    public static void findMissingLetters(String input){

        final int MAX_CHARS = 26;
        boolean[] present = new boolean[MAX_CHARS];
        List<Character> charsList = new ArrayList<>();

        String a = input.toLowerCase();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++){
            if('a' <= a.charAt(i) && a.charAt(i) <= 'z'){
                present[a.charAt(i) - 'a'] = true;
            }
        }
        for (int i = 0; i < MAX_CHARS; i++){
            if(!present[i]){
                charsList.add((char)(i + 'a'));
            }
        }
        for (char b:charsList) {
            output.append(b);
        }
        System.out.println("missing " + output);

    }
}
