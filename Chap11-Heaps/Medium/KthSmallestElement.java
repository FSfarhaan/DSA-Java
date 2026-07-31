class MaxHeap {
    int capacity;
    int size;
    int[] arr;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    int Parent(int i) {
        return (i - 1) / 2;
    }

    int Left(int i) {
        return 2 * i + 1;
    }

    int Right(int i) {
        return 2 * i + 2;
    }

    void Insert(int x) {
        if (size == capacity) {
            return;
        }

        arr[size] = x;
        int k = size;
        size++;

        while (k != 0 && arr[Parent(k)] < arr[k]) {
            int temp = arr[Parent(k)];
            arr[Parent(k)] = arr[k];
            arr[k] = temp;

            k = Parent(k);
        }
    }

    int ExtractMax() {
        if (size <= 0)
            return Integer.MIN_VALUE;

        if (size == 1) {
            size--;
            return arr[0];
        }

        int max = arr[0];
        arr[0] = arr[size - 1];
        size--;

        Heapify(0);

        return max;
    }

    void Heapify(int i) {
        int left = Left(i);
        int right = Right(i);

        int largest = i;

        if (left < size && arr[left] > arr[largest])
            largest = left;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            Heapify(largest);
        }
    }

    int getMax() {
        return arr[0];
    }

    void Print() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

public class KthSmallestElement {

    static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        MaxHeap heap = new MaxHeap(k);

        // Insert first k elements
        for (int i = 0; i < k; i++) {
            heap.Insert(matrix[i / n][i % n]);
        }

        // Process remaining elements
        for (int i = k; i < n * n; i++) {
            int curr = matrix[i / n][i % n];

            if (curr < heap.getMax()) {
                heap.ExtractMax();
                heap.Insert(curr);
            }
        }

        return heap.getMax();
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;

        System.out.println(kthSmallest(matrix, k)); // 13
    }
}