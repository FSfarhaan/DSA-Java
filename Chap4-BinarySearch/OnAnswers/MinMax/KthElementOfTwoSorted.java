public class KthElementOfTwoSorted {

    // Direct Optimal Approach as it is the same as Median of two sorted arrays, instead the cut would be k;
    static double getKthElement(int arr1[], int arr2[], int k) {
        int n1 = arr1.length, n2 = arr2.length;
        if(n1 > n2) return getKthElement(arr2, arr1, k);

        // We know from start, how many elements on left would be;
        int left = k;
        int low = Math.max(0, k - n1), high = Math.min(k, n2);

        while (low <= high) {
            int cut1 = low + (high - low) /2;
            int cut2 = left - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n1? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n2? Integer.MAX_VALUE : arr2[cut2];

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else low = cut1 + 1;
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int arr1[] = { 100, 112, 256, 349, 770 }, arr2[] = { 72, 86, 113, 119, 265, 445, 892 };
        int k = 7;
        System.out.println("The kth element is: "+ getKthElement(arr1, arr2, k));
    }
}
