import java.util.*;
import java.util.stream.Collectors;

public class birthdayMemorization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfFriends = sc.nextInt();

        List<String>friendList = new ArrayList<>();
        ArrayList<String>dateList = new ArrayList<>();
        List<Birthday> birthdayList = new ArrayList<>();
        List<String> compareList = new ArrayList<>();

        /**
         * Loop number of times specified by numberOfFriends
         * Scan for user input x number of times
         * add input to friendList
         */
        for(int i = 0; i < numberOfFriends + 1; i++){
            String input = sc.nextLine();
            friendList.add(input);
        }

        /**
         * Loop through friendList and split the lines by whitespace and into an array.
         * initialise variables name, date and rate with arr[i].
         * populate birthday with name, date and rate.
         * add to birthdayList.
         * add date to dateList.
         */
        for(int i = 1; i < friendList.size(); i++){
            String line = friendList.get(i);
            String arr[] = line.split(" ", 3);
            String name = arr[0];
            int rate = Integer.parseInt(arr[1]);
            String date = arr[2];

            Birthday birthday = new Birthday(name,date,rate);
            birthdayList.add(birthday);
            compareList.add(birthday.getName());

            dateList.add(date);

        }
        //Create array dates populate with dateList
        String[] dates = dateList.toArray(new String[0]);
        // Create HashSet and use method getDuplicateDates to find dates with multiple instances.
        HashSet<String> duplicateSet;
        duplicateSet = getDuplicateDates(dates);
        // Use getArrayFromHashSet to convert hashset to array.
        String[] datesThatOccurMoreThanOnce = getArrayFromHashSet(duplicateSet);
        List<Birthday> names = new ArrayList<>();
        List<String> finalNameList = new ArrayList<>();
        List<String> list;

        String name;


        for(int i = 0; i < datesThatOccurMoreThanOnce.length; i++) {
            names = getNamesBelongingToDate(birthdayList, datesThatOccurMoreThanOnce[i]);
            name = mostValuedFriend(names);
            finalNameList.add(name);
        }

        list = getListOfBirthdaysWithMultipleDates(birthdayList, datesThatOccurMoreThanOnce);

        List<String> nameList = new ArrayList<>();
        List<String> unique;

        nameList = getSingleDateNamesFromList(compareList, list);
        unique = removeDuplicatesFromFinalList(nameList);


        for(String uni : unique ){
            finalNameList.add(uni);
        }

        //Sort finalNameList alphabetically
        Collections.sort(finalNameList);

        System.out.println(finalNameList.size());
        finalNameList.forEach(System.out::println);

    }

    /**
     * Returns dates that occur more than once in array dates.
     * @param  dates
     * @return dateDoubleSet
     */
    public static HashSet<String> getDuplicateDates(String[] dates){

        Arrays.sort(dates);
        HashSet<String> dateSet = new HashSet<>();
        HashSet<String> dateDoubleSet = new HashSet<>();

        for(String date : dates){
            if(dateSet.add(date) == false){
                dateDoubleSet.add(date);

            }
        }
        return dateDoubleSet;
    }

    /**
     * Returns an array converted from the HashSet received.
     * @param hashSet
     * @return
     */
    public static String[] getArrayFromHashSet(HashSet<String> hashSet){

        ArrayList<String> arrayList = new ArrayList<>();
        for(String set : hashSet){
            arrayList.add(set);
        }
        String[] array = arrayList.toArray(new String[0]);

        return array;
    }

    public static List<String> getListOfBirthdaysWithMultipleDates(List<Birthday> birthdays, String[] a){

        List<String> list = new ArrayList<>();
        for(Birthday birthday : birthdays){
            for(int i = 0; i < a.length; i++){
                if(a[i].equals(birthday.getDate())){
                    list.add(birthday.getName());
                }
            }
        }
        return list;
    }

    public static List<String> getSingleDateNamesFromList(List<String> a, List<String> b){

        List<String> singleDateNameList = new ArrayList<>();
        boolean found = false;
        String odd = null;
        for (String i : a) {
            for (String j : b) {
                if (i == j)
                    found = true;
            }
            if (!found)
                odd = i;

            found = false;
            singleDateNameList.add(odd);
        }
        return singleDateNameList;
    }

    public static List<String> removeDuplicatesFromFinalList(List<String> a){
        List<String> removeDuplicates = a.stream()
                .distinct()
                .collect(Collectors.toList());

        removeDuplicates.remove(null);

        return removeDuplicates;
    }

    public static List<Birthday> getNamesBelongingToDate(List<Birthday> birthdayList, String a ){
        List<Birthday> listOfNamesBelongingToDate = new ArrayList<>();

        for(Birthday birthday : birthdayList){
            if(a.equals(birthday.getDate())){
                listOfNamesBelongingToDate.add(birthday);
            }
        }
        return listOfNamesBelongingToDate;
    }

    public static String mostValuedFriend(List<Birthday> names){

        String mvp = "No name found!";
        names.sort(Comparator.comparing(Birthday::getRating).reversed());
        mvp = names.stream().findFirst().get().getName();

        return mvp;
    }

    public static class Birthday {

        private String name;
        private String date;
        private int rating;

        public Birthday(String name, String date, int rating) {
            this.name = name;
            this.date = date;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return String.format("%-4s %-4s %4d ",
                    getName(), getDate(), getRating());
        }
    }




}
