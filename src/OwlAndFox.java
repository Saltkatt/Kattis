import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class OwlAndFox {

    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        int inputNumbers = 0;
        List<Integer> numbers = new ArrayList<>();


        if(sc.hasNextInt())
            inputNumbers = sc.nextInt();

        for(int i = 0; i < inputNumbers; i++){
              numbers.add(sc.nextInt());
        }

        getNumbers(numbers);
        sc.close();
    }

    public static void getNumbers(List<Integer> numbers){

        for (int number: numbers) {
            int[] digits = splitNumberStringByDigit(number);
            List<Integer> digitList = createDigitList(digits);
            Integer[] d = appendList(digitList);
            arrayToIntAndPrint(d);
        }

    }

    public static int[] splitNumberStringByDigit(int number){

        String numberString = String.valueOf(number);

        return Arrays.stream(numberString.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
    // Convert array to list and return the list.
    public static List<Integer> createDigitList(int[] digits){

        return Arrays.stream(digits)
               .boxed()
               .collect(Collectors.toList());
    }

    //Loop through list in reverse
    //check if digit is > 0 and subtract 1 from digit
    // change list at index, return array.
    public static Integer[] appendList(List<Integer> digitList){

        for(int i = digitList.size(); i-- > 0;) {
            if (digitList.get(i) > 0) {
                int sum = digitList.get(i) - 1;
                digitList.set(i, sum);
                break;
            }
        }
        return digitList.toArray(new Integer[0]);

    }

    public static void arrayToIntAndPrint( Integer[] digits){
        StringBuilder strNumber = new StringBuilder();
        Arrays.stream(digits).forEach(strNumber::append);
        System.out.println(Integer.parseInt(strNumber.toString()));
    }
}

