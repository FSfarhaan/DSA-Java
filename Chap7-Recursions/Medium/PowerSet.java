import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static void generatePowerSet(int index, String s, String ds, List<String> ans) {
        if(index == s.length()) {
            ans.add(ds);
            return;
        }

        generatePowerSet(index+1, s, ds + s.charAt(index), ans);
        ds.substring(0, ds.length());

        generatePowerSet(index+1, s, ds, ans);
    }
    static List<String> getPowerset(String s) {
        List<String> ans = new ArrayList<>();
        generatePowerSet(0, s, "", ans);
        return ans;
    }
    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = getPowerset(str);
        System.out.println(ans.size());

        for(String st: ans) {
            System.out.println(st);
        }
    }
}
