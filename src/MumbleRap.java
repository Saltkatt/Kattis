import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MumbleRap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int lengthOfString = sc.nextInt();
        sc.nextLine();
        char[] chars = new char[lengthOfString];
        sc.nextLine().getChars(0, lengthOfString, chars, 0);
        String rapLine = new String(chars);

        List<String> integerList = findNumbers(rapLine);

        List<Integer> numbers = new ArrayList<>();
        for(String s : integerList){
            numbers.add(Integer.parseInt(s));
        }
        int maxNumber = Collections.max(numbers);
        System.out.println(maxNumber);

        sc.close();

    }

    public static List<String> findNumbers(String rapLine){
        Pattern integerPattern = Pattern.compile("-?\\d+");
        Matcher matcher = integerPattern.matcher(rapLine);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()){
            integerList.add(matcher.group());
        }

        return integerList;
    }

}
