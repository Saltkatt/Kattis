import java.util.Scanner;

public class TheOwlAndFox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int n = sc.nextInt();
            int t = n;
            int pow = 1;
            while (t % 10 == 0) {
                pow *= 10;
                t /= 10;
            }
            System.out.println(n - pow);
        }
        sc.close();
    }



}
