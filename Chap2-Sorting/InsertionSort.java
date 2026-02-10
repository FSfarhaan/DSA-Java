public class InsertionSort {
    static void insertSort(int arr []) {
        // { 113, 46, 24, 52, 20, 9 }
        // i = 0; j = i + 1 = 1;
        // while(j > 0 && arr[j] < arr[j - 1]) -> swap the currentNum with the prevNum; j--;
        // 
        // { 46, 113, 24, 52, 20, 9 }

        // i = 1; j = 2
        // 24 < 113 swap. j = 1;
        // 24 < 46 swap. j = 0; stop.

        // { 24, 46, 113, 52, 20, 9 }
        // i = 2; j = 3;
        // 52 < 113. Swap. j = 2;
        // 
        
        for(int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while(j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
            
        }
    }

    static void recInsertSort(int [] arr, int range) {
        int j = range + 1;

        if(arr.length - 1 == range) return;
        while(j > 0 && arr[j] < arr[j - 1]) {
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }
        recInsertSort(arr, range + 1);
    }
    public static void main(String[] args) {
        int arr[]  = { 113, 46, 24, 52, 20, 9 };

        System.out.println("Before Sorting");
        // for (int num : arr) {
        //     System.out.print(num + " ");
        // }

        // insertSort(arr);
        recInsertSort(arr, 0);
        System.out.println();
        System.out.println("After Sorting");
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}
