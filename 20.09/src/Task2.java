import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 27.09.2016.
 */
public class Task2 {
    public static void doInspection(File file, String s, String a, String b) throws IOException {
        Scanner scanner = new Scanner(new File("input2"));
        String x = "";
        while (scanner.hasNext()) {
            x += scanner.nextLine();
        }
        int count = 0;
        Pattern p = Pattern.compile(s, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(x);
        while (m.find()) count++;
        x = x.replaceAll(a,b);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output2"));
        bufferedWriter.write(x);
        bufferedWriter.newLine();
        bufferedWriter.write("s has met " + count + " time");
        bufferedWriter.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        //doInspection();
    }
}
