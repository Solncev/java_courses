import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 20.09.2016.
 */
public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("input1")));
        String[] ss;
        Pattern p = Pattern.compile("");
        Pattern p2 = Pattern.compile("(\\w){1,}(.|,)(\\w){1,}");

        Matcher m;

        String s = "";
        Boolean flag = true;
        while ((s = br.readLine()) != null && flag) {
            ss = s.split(" ");
            for (String word : ss) {
                m = p.matcher(word);
                if (m.matches()) {
                    System.out.println("Has 2 or more spaces!");
                    flag = false;
                }
                m = p2.matcher(word);
                if (m.matches()) {
                    System.out.println("There is a point or coma with no space after!");
                    flag = false;
                }
            }
        }
        if (flag) System.out.println("all rigth");
    }
}