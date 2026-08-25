import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for(int[] interval: intervals) {
            if(merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1])
                merged.add(new int[] { interval[0], interval[1]});
            else 
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for(int[] interval: intervals) list.add(new int[] {  interval[0], interval[1] });
        list.add(new int[] { newInterval[0], newInterval[1] });

        return merge(list.toArray(new int[list.size()][]));
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 2}, {3, 5}, {6, 7}, { 8, 10}, {12, 16}};
        int[] newInterval = { 4, 8 };

        int[][] ans = insert(intervals, newInterval);

        for(int[] i: ans) {
            for(int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
