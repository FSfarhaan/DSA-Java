import java.util.ArrayList;

public class MergeSort {
    static void merge(int [] arr, int low, int mid, int high) {
        int left = low, right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(left <= mid && right <= high) {
            if(arr[left] < arr[right]) temp.add(arr[left++]);
            else temp.add(arr[right++]);
        }

        while(left <= mid) {
            temp.add(arr[left++]);
        }
        while (right <= high) {
            temp.add(arr[right++]);
        }

        // Transferring from temp to the original array;

        for(int i = low; i <= high; i ++) {
            arr[i] = temp.get(i - low);
        }
        
    }
    static void mergeSort(int [] arr, int low, int high){
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void main(String[] args) {
        int arr[]  = new int[]{ 13, 46, 24, 52, 20, 9 };

        System.out.println("Before Sorting");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergeSort(arr, 0, arr.length - 1);
        System.out.println();
        System.out.println("After Sorting");
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}
