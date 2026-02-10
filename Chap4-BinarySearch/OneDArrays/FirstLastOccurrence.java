public class FirstLastOccurrence {
    // Brute force
    static void getOccurrences(int arr[], int target) {
        int first = -1, last = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                if(first == -1) first = i;
                last = i;
            }
        }

        System.out.println("First and last indexes are: " + first + " " + last);
    }

    // Optimal approach
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

        System.out.println("First and last occurences are: " + first + " " + last);
    }
    public static void main(String[] args) {
        int arr[] = {3,4,13,13,13,20,40};
        int target = 20;
        // getOccurrences(arr, target);
        OptGetOccurrences(arr, target);
    }
}
