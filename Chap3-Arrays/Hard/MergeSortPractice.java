import java.util.ArrayList;

public class MergeSortPractice {

    // Merging
    static void merge(int arr[], int low, int mid, int high) {
        int left = low, right = mid + 1;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) arrayList.add(arr[left++]);
            else arrayList.add(arr[right++]);
        }

        while(left <= mid) arrayList.add(arr[left++]);
        while(right <= high) arrayList.add(arr[right++]);
        for(int i = low; i <= high; i ++) {
            arr[i] = arrayList.get(i - low);
        }
    }

    // Dividing
    static void mergeSort(int arr[], int low, int high) {
        if(low == high) return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }
    
    public static void main(String[] args) {
        int arr[] = {5,3,2,1,4};
        mergeSort(arr, 0, arr.length - 1);

        for(int it: arr){
            System.out.print(it + " ");
        }
        // 5, 3, 2
        // 1, 4

        // 5, 3, 2 => 5, 3 || 2

        // 5, 3 => 5, 3


    }
}
