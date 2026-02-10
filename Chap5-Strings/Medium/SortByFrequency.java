import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {
    // Brute force (TC -> 2n + 2nlogn, SC -> 2n);
    static String getFrequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        ); 

        queue.addAll(map.entrySet());

        while (!queue.isEmpty()) {
            int times = queue.peek().getValue();
            char c = queue.poll().getKey();
            while (times != 0) {
                times--;
                ans.append(c);
            }
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "Aabb";
        // tree -> eert
        // tttree -> eerttt -> ttteer
        System.out.println(getFrequency(s));
    }
}
