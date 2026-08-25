import java.util.Arrays;

public class JobSequencingProblem {

    static int maximizeProfit(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        int n = jobs.length;

        int profit = 0;
        int[] arr = new int[n + 1];

        for(int[] job: jobs) {
            if(arr[job[1]] == 0) {
                arr[job[1]] = 1;
                profit += job[2];
            }
            else {
                int i = job[1];
                while (i > 0) {
                    if(arr[i] == 0) {
                        arr[i] = 1;
                        profit += job[2];
                        break;
                    }
                    i--;
                }
            }
        }

        return profit;
    }
    public static void main(String[] args) {
        int[][] jobs = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};
        System.out.println(maximizeProfit(jobs));
    }
}
