import java.util.Arrays;

public class KthLargestElement {

    // Brute force (TC -> nlogn, SC -> 1);
    static int BrutefindKthLargest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        return arr[n - k];
    }


    static int Parent(int i) {
        return (i - 1) / 2;
    }

    static int Left(int i) {
        return 2 * i + 1;
    }

    static int Right(int i) {
        return 2 * i + 2;
    }

    static void Insert(int[] heap, int x, int size) {

        heap[size] = x;

        int k = size;

        while (k != 0 && heap[Parent(k)] > heap[k]) {

            int temp = heap[Parent(k)];
            heap[Parent(k)] = heap[k];
            heap[k] = temp;

            k = Parent(k);
        }
    }

    static void Heapify(int i, int[] heap, int size) {

        int smallest = i;

        int left = Left(i);
        int right = Right(i);

        if (left < size && heap[left] < heap[smallest])
            smallest = left;

        if (right < size && heap[right] < heap[smallest])
            smallest = right;

        if (smallest != i) {

            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;

            Heapify(smallest, heap, size);
        }
    }

    static int ExtractMin(int[] heap, int size) {

        int min = heap[0];

        heap[0] = heap[size - 1];

        Heapify(0, heap, size - 1);

        return min;
    }

    // Better Approach (TC -> nlogk, SC -> k);
    static int findKthLargest(int[] nums, int k) {

        int[] heap = new int[k];

        int size = 0;

        // Build heap using first k elements
        for (int i = 0; i < k; i++) {

            Insert(heap, nums[i], size);
            size++;
        }

        // Process remaining elements
        for (int i = k; i < nums.length; i++) {

            if (nums[i] > heap[0]) {

                ExtractMin(heap, size);

                Insert(heap, nums[i], size - 1);
            }
        }

        return heap[0];
    }

    public static void main(String[] args) {
        int[] arr = { 3,2,3,1,2,4,5,5,6 };
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }
}
