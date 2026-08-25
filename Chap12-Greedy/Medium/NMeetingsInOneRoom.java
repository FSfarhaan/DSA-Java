import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NMeetingsInOneRoom {

    static List<Integer> nMeetings(int[] start, int[] end) {
        List<int[]> meetings = new ArrayList<>();

        for(int i = 0; i < start.length; i++) {
            meetings.add(new int[] {start[i], end[i], i + 1});
        }

        meetings.sort((a, b) -> a[1] - b[1]);

        int lastTime = -1;
        List<Integer> result = new ArrayList<>();

        for(int[] m: meetings) {
            if(m[0] >= lastTime) {
                result.add(m[2]);
                lastTime = m[1];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5}, end =  {2,4,5,7,9,9};
        List<Integer> ans = nMeetings(start, end);

        for(int k: ans) {
            System.out.print(k + " ");
        }

        // If asked for number of meetings;
        // System.out.println(ans.size());
    }   
}
