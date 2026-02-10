
public class FindOccurences {

    static int OptGetFirst(int arr[], int target) {
        int first = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                high = mid - 1;
                first = mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return first;
    }

    static int OptGetLast(int arr[], int target) {
        int last = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target)  {
                low = mid + 1;
                last = mid;
            } else if(arr[mid] < target) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return last;
    }


    static void OptGetOccurrences(int arr[], int target) {
        int first = OptGetFirst(arr, target);
        int last = OptGetLast(arr, target);

        System.out.println("Number of occurrences are: " + (last - first + 1) );
    }

    public static void main(String[] args) {
        int arr[] = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int target = 4;
        OptGetOccurrences(arr, target);
    }
}
