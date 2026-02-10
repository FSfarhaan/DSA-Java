
class LeftRotateByK {
    // brute force {TC -> 2(k + n), SC -> k}
    static void leftRotate(int [] arr, int k ) {
        k = k % arr.length;
        int temp[] = new int[k];

        for(int i = 0; i < k; i ++) {
            temp[i] = arr[i];
        }

        for(int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        } 

        for(int i = 0; i < temp.length; i++) {
            arr[arr.length - k + i] = temp[i];
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void reverseArray(int arr [], int start, int end) {
        // 1st pass
        // i = 0 ; i < 1;
        // temp  = 1;
        // arr[0] = 3;
        // arr[1] = 
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++; end--;
        }
    }

    // Optimal Approach (TC -> n, SC -> 1);
    static void OptLefRotate(int arr[], int k) {
        int n = arr.length;

        // Reverse from 0 to k -1 , then reverse k to n -1, then reverse 0 to n- 1
        // { 1, 2, 3, 4, 5, 6} k = 3
        // { 3, 2, 1, 6, 5, 4 }
        // { 4, 5, 6, 1, 2, 3 }


        //  For left => k, For right => n -k
        reverseArray(arr, 0, k - 1); // { k = 3, 0 - 2}
        reverseArray(arr, k , n - 1); // { 3, 5}
        reverseArray(arr, 0, n - 1); // { 0 - 5}

        for(int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int k = 2;
        OptLefRotate(arr, k);
    }
}