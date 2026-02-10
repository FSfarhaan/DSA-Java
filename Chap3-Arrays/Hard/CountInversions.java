import java.util.ArrayList;

public class CountInversions {
    // Brute force (TC -> n2, SC -> 1);
    static void countPairs(int arr[]) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        System.out.println("Number of pairs are: " + count);
    }


    // Merging
    static int merge(int arr[], int low, int mid, int high) {
        int left = low, right = mid + 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) arrayList.add(arr[left++]);
            else {
                arrayList.add(arr[right++]);
                count += mid - left + 1;
            }
        }

        while(left <= mid) arrayList.add(arr[left++]);
        while(right <= high) arrayList.add(arr[right++]);
        for(int i = low; i <= high; i ++) {
            arr[i] = arrayList.get(i - low);
        }

        return count;
    }

    // Dividing
    static int mergeSort(int arr[], int low, int high) {
        int count = 0;
        if(low == high) return count;
        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += merge(arr, low, mid, high);
        
        return count;
    }


    // Optimal Approach using merge sort
    static void OptCountInvers(int arr[]) {
        int pairs = mergeSort(arr, 0, arr.length - 1);
        System.out.println("Pairs are " + pairs);
    }
    public static void main(String[] args) {
        int arr[] = {5,3,2,1,4};
        // countPairs(arr);
        OptCountInvers(arr);
    }
}
