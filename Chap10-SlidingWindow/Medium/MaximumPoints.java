public class MaximumPoints {

    // Optimal approach (TC -> 2k, SC -> 1);
    static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int max = 0;

        int leftSum = 0, rightSum = 0;
        for(int i = k - 1; i >= 0; i--) {
            leftSum += cardPoints[i];
        }
        
        // System.out.println(leftSum);

        max = leftSum;


        int j = n - 1;
        for(int i = k - 1; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[j];
            j--;

            max = Math.max(max, leftSum + rightSum);
            System.out.println("Ab ke liye max ye hai " + max);
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 8, 7, 1, 3 }; 
        int k = 3;

        System.out.println(maxScore(arr, k));

    }
}
