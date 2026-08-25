import java.util.Arrays;

public class NonOverlappingIntervals {

    static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for(int[] i: intervals) {
            System.out.println(i[0] + " " + i[1]);
        }

        int ans = 0;
        int latest = intervals[0][0];

        for(int[] interval: intervals) {
            if(interval[0] < latest) {
                // System.out.println("Andar kais aaya " + interval[0] + " and " + latest);
                ans++;
            }
            else {
                latest = interval[1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = { {1, 2}, {2, 3} };
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
