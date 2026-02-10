public class SmallestDivisor {

    static int getDivisor(int arr[], int ele) {
        int divisors = 0;
        for(int i = 0; i < arr.length; i++) {
            divisors += (int)Math.ceil((double)arr[i] / ele);
        }

        return divisors;
    }

    // Brute force (TC -> n * (max), SC -> 1)
    static int getSmallestDivisor(int arr[], int limit) {
        int max = Integer.MIN_VALUE;
        int result = -1;

        for(int ele: arr) {
            max = Math.max(ele, max);
        }

        for(int i = 1; i < max; i++) {
            int divisors = getDivisor(arr, i);
            if(divisors >= limit) {
                result = i;
            } else return i;
        }

        return result;
    }

    // Optimal approach (TC -> n * max, SC -> 1);
    static int OptGetSmallestDivisor(int arr[], int limit) {
        if (arr.length > limit) return -1;
        int low = 1, high = Integer.MIN_VALUE;
        for(int ele: arr) {
            high = Math.max(high, ele);
        }
        if(limit == arr.length) return high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int divisors = getDivisor(arr, mid);
            if(divisors <= limit) {
                high = mid - 1;
            } else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {
        int arr[] = {44,22,33,11,1}, limit = 5;
        // System.out.println("Smallest divisor is: " + getSmallestDivisor(arr, limit));
        System.out.println("Smallest divisor is: " + OptGetSmallestDivisor(arr, limit));
    }
}
