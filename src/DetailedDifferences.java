import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

/*


class DetailedDifferences {

    public static void main(String[] args) {

        Kattio io = new Kattio(System.in, System.out);

        int i = 0;
        int numberOfInput = 0;
        String reference = null;
        String comparison = null;

        if (io.hasMoreTokens())
            numberOfInput = io.getInt();

        for (i = 0; i < numberOfInput; i++) {

            if (io.hasMoreTokens())
                reference = io.getWord();

            if (io.hasMoreTokens())
                comparison = io.getWord();

            System.out.println('\n' + reference + '\n' + comparison + '\n' + differ(reference, comparison));

        }
        io.close();

    }

    public static String differ(String reference, String comparison) {

        String difference = "";
        StringBuilder differ = new StringBuilder(reference.length());
        differ.append(difference);

        for (int i = 0; i < reference.length(); i++) {
            if (reference.charAt(i) == comparison.charAt(i)) {
                differ.append(".");
            } else {
                differ.append("*");
            }

        }
        difference = differ.toString();

        return difference;
    }
}*/
