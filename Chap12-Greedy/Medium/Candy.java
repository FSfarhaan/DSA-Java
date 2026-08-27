public class Candy {

    // Brute force (TC -> 3n, SC -> 2n);
    static int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else
                left[i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else
                right[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            sum += Math.max(right[i], left[i]);
        }

        return sum;
    }

    // Better (TC -> 2n, SC -> n);
    static int BetCandy(int[] ratings) {
        int n = ratings.length;

        int[] left = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int sum = left[n - 1];
        int cur = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                cur++;
            } else {
                cur = 1;
            }

            sum += Math.max(cur, left[i]);
        }

        return sum;
    }

    // Optimal approach
    static int OptCandy(int[] ratings) {
        int n = ratings.length;

        int sum = 1, i = 1;
         
        while (i < n) {
            if(ratings[i] == ratings[i-1]) {
                sum += 1;
                i++; continue;
            }

            // Upward
            int peak = 1;
            while (i < n && ratings[i] > ratings[i-1]) {
                peak++;
                sum += peak;
                i++;
            }

            int down = 1;
            while (i < n && ratings[i] < ratings[i-1]) {
                sum += down;
                i++;
                down++;
            }

            if(down > peak) sum += down - peak;

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = { 1,3,2,2,1 };
        System.out.println(OptCandy(ratings));
    }
}
