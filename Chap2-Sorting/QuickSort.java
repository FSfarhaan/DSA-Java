public class QuickSort {
    static int getPartition(int [] arr, int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;

        // { 13, 46, 24, 52, 20, 9 }
        while(i < j) {
            while(arr[i] <= pivot && i < high) i++;
            while(arr[j] > pivot && j > low) j--;
    
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }   

    public static void quickSort(int arr[], int low, int high) {
        if(low < high) {
            int partition = getPartition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition+ 1, high);
        }
    }
    public static void main(String[] args) {
        int arr[]  = new int[]{ 4, 6, 2, 5, 7, 9, 1, 3 };

        System.out.println("Before Sorting");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("After Sorting");
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}
