public class BinaryHeap {
    int capacity;
    int size;
    int[] arr;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
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
        if(size == capacity) {
            System.out.println("Heap size is full cannot add more elements");
            return;
        }

        arr[size] = x;

        int k = size;
        size++;

        while (k != 0 && arr[Parent(k)] > arr[k]) {
            int temp = arr[Parent(k)];
            arr[Parent(k)] = arr[k];
            arr[k] = temp;

            k = Parent(k);
        }
    }

    int GetMin() {
        return arr[0];
    }

    int ExtractMin() {
        if (size <= 0)
          return Integer.MAX_VALUE;

        if(size == 1) {
            size--;
            return arr[0];
        }

        int min = arr[0];

        arr[0] = arr[size - 1];
        size--;

        Heapify(0);

        return min;
    }

    void Heapify(int i) {
        int Left = Left(i);
        int Right = Right(i);

        int smallest = i;

        if(arr[Left] < arr[i] && arr[Left] < arr[Right]) smallest = Left;
        if(arr[Right] < arr[i] && arr[Right] < arr[Left]) smallest = Right;

        if(smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            Heapify(smallest);
        }
    }

    void DecreaseKey(int i, int val) {
        arr[i] = val;

        while (i != 0 && arr[Parent(i)] > arr[i]) {
            int temp = arr[Parent(i)];
            arr[Parent(i)] = arr[i];
            arr[i] = temp;

            i = Parent(i);
        }
    }

    void Delete(int i) {
        DecreaseKey(i, Integer.MIN_VALUE);
        ExtractMin();
    }

    void Print() {
        for(int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        BinaryHeap h = new BinaryHeap(20);

        h.Insert(4);
        h.Insert(1);
        h.Insert(2);
        h.Insert(6);
        h.Insert(7);
        h.Insert(3);
        h.Insert(8);
        h.Insert(5);

        System.out.println("Min value is " + h.GetMin());

        h.Insert(-1);
        System.out.println("Min value is " + h.GetMin());

        h.DecreaseKey(3, -2);
        System.out.println("Min value is " + h.GetMin());

        h.ExtractMin();
        System.out.println("Min value is " + h.GetMin());

        h.Delete(0);
        System.out.println("Min value is " + h.GetMin());
    }
}
