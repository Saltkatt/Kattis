import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class birthdayProcessMemory {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        int numberOfFriends = sc.nextInt();
        List<String> friendList;
        friendList = populateListOfStrings(numberOfFriends);

        List<Birthday[]> birthdayList = splitLinesOfListAndPopulateNewArray(friendList);

        birthdayList.forEach(birthdays -> System.out.println("c: " + Arrays.stream(birthdays).findFirst()));
        //birthdayList.stream().forEach(System.out::println);








    }

    /**
     * Loop number of times specified by numberOfFriends
     * Scan for user input x number of times
     * add input to friendList
     */
    public static List<String> populateListOfStrings(int numberOfFriends ){
        List<String> friendList = new ArrayList<>();
        for(int i = 0; i < numberOfFriends + 1; i++){
            String input = sc.nextLine().toLowerCase();
            friendList.add(input);
        }
        return friendList;
    }

    /**
     * Loop through friendList and split the lines by whitespace and into an array.
     * initialise variables name, date and rate with arr[i].
     * populate birthday with name, date and rate.
     * add to birthdayList.
     */
    public static List<Birthday[]> splitLinesOfListAndPopulateNewArray(List<String> friendList){

        List<Birthday[]> birthdayList = new ArrayList<>();
        for(int i = 1; i < friendList.size(); i++) {
            String line = friendList.get(i);
            String arr[] = line.split(" ", 3);
            String name = arr[0];
            int rate = Integer.parseInt(arr[1]);
            String date = arr[2];

            Birthday[] birthdays = {
                    new Birthday(name, date, rate)
            };
           Collections.addAll(birthdayList, birthdays);

        }
        //birthdayList.forEach(birthdays -> System.out.println("b: " + Arrays.stream(birthdays).findFirst()));
        return birthdayList;
    }

    public static List<Birthday[]> findDatesWithDuplicates(List<Birthday[]> a){

        Function<Birthday, String> byDate = Birthday::getDate;
        List<Birthday[]> birthdays = new ArrayList<>();

        return birthdays;

   }
}
