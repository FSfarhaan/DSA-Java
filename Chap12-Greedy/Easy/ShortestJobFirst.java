import java.util.Arrays;

public class ShortestJobFirst {

    static int getWaitTime(int[] jobs) {
        Arrays.sort(jobs);

        int waitTime = 0;
        int totalTime = 0;
        int n = jobs.length;
        
        for(int i = 0; i < n; i++) {
            waitTime += totalTime;
            totalTime += jobs[i];
        }

        return waitTime / n;
    }
    public static void main(String[] args) {
        int[] jobs = { 3, 1, 4, 2, 5 };
        // sorted -> 1, 2, 3, 4, 5
        // (0 + 1) + (1 + 2) + (3 + 3) + (6 + 4) = 20 / 5 = 4
        System.out.println(getWaitTime(jobs));
    }
}