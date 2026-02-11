import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    static void generateBS(int n, String curr, List<String> result) {
        if(curr.length() == n) {
            result.add(curr);
            return;
        }

        generateBS(n, curr + "0", result);

        if(curr.isEmpty() || curr.charAt(curr.length() - 1) != '1') {
            generateBS(n, curr + "1", result);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        generateBS(n, "", result);

        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
