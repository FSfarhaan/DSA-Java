public class BubbleSort {
    static void bubbSort(int [] arr) {
        boolean flag = true;
        
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag) return;
        }
    }

    // Recursion Approach
    static void recBubbSort(int [] arr, int range) {
        if(range == 1)  return;
        
        boolean didSwap = false;
        for(int i = 0; i < range - 1; i++) {
            if(arr[i] > arr[i+1]) {
                System.out.println("hello");
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                didSwap = true;
            }
        }

        if(!didSwap) return;
        recBubbSort(arr, range - 1);
    }
    public static void main(String[] args) {
        // int arr[]  = { 100, 46, 24, 52, 200, 9 };
        int arr[]  = { 1, 2, 3, 4, 5, 6 };

        System.out.println("Before Sorting");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // bubbSort(arr);
        recBubbSort(arr, arr.length);
        System.out.println();
        System.out.println("After Sorting");
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}
