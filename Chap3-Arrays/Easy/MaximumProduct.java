public class MaximumProduct {

    // Brute Force (TC -> n2, SC -> 1);
    static void getMaximum(int arr[]) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int prod = 1;
            for(int j = i; j < n; j++) {
                prod = prod * arr[j];
                System.out.println("Prod: " + prod);
                max = Math.max(max, prod);
                System.out.println("Max: " + max);
            }
        }

        System.out.println("The maximum is: " + max);
    }

    // Optimal Approach
    static void OptGetMax(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int pref = 1, suff = 1;

        for(int i = 0; i < n; i++) {
            if(pref == 0) pref = 1;
            if(suff == 0) suff = 1;

            pref = pref * arr[i];
            suff = suff * arr[n - 1 - i];

            max = Math.max(max, Math.max(pref, suff));
        }

        System.out.println("The maximum is: " + max);

    }
    public static void main(String[] args) {
        int arr[] = {2,3,-2,4};

        // getMaximum(arr);
        OptGetMax(arr);
    }
}
