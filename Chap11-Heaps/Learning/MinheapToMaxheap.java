public class MinheapToMaxheap {

    static int Left(int i) {
        return  2 * i + 1;
    }

    static int Right(int i) {
        return 2 * i + 2;
    }

    static void MaxHeapify(int[] arr, int i, int n) {
        int left = Left(i);
        int right = Right(i);

        int largest = i;

        if(left < n && arr[left] > arr[largest]) largest = left;

        if(right < n && arr[right] > arr[largest]) largest = right;

        if(largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            MaxHeapify(arr, largest, n);
            
        }
    }

    static void toMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            MaxHeapify(arr, i, n);
        }
    }
    
    static void Print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 5, 7, 3, 8, 6 };
        toMaxHeap(arr);
        Print(arr);
    }
}
