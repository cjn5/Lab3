
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebContentLab {

    public static void main(String[] args) {
        urlToString("http://erdani.com/tdpl/hamlet.txt");

    }

    public static String urlToString(final String url) {
        Scanner urlScanner;
        String constant = "prince";
        int count = 0;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        String line = contents.toLowerCase();
        urlScanner.close();
        while (line.indexOf(constant) != -1) {
            line = line.substring(line.indexOf(constant) + constant.length(), line.length());
            count++;
        }

        System.out.println("The text has the word " + constant + " " + count + " times");

        return contents;
    }
}
