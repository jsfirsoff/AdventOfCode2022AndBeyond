import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static int solve() throws FileNotFoundException {
        Scanner scn = new Scanner(new File("src/data"));
        scn.useDelimiter("\\r\\n");
        ArrayList<Integer> list = new ArrayList<>();

        while (scn.hasNext()) {
            int total = 0;
            var s = scn.next();
            while(!s.isBlank()) {
                total += Integer.parseInt(s);
                if (!scn.hasNext()) break;
                s = scn.next();
            }
            list.add(total);
        }
        scn.close();
        return list.stream().max(Comparator.naturalOrder()).orElse(-1);
    }
}
