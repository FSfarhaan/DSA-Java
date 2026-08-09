import java.util.Arrays;

public class AssignCookies {

    static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0, right = 0;
        int n = g.length, m = s.length;

        while (left < n && right < m) {
            if(s[right] >= g[left]) {
                left++;
            }

            right++;
        }

        return left;
    }
    
    public static void main(String[] args) {
        int[] g = {1, 2}, s = {1, 2, 3};
        // 7, 8, 9, 10 -> 5, 6, 7, 8

        long start = System.nanoTime();

        System.out.println(findContentChildren(g, s));

        long end = System.nanoTime();

        System.out.println("Time = " + ((end - start) / (1e+6)) + " ms");

    }
}
