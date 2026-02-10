public class FloorCeil {
    static int floor (int arr[], int target) {
        int floor = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] <= target) {
                low = mid + 1;
                floor = arr[mid];
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }

    static int ceil (int arr[], int target) {
        int ceil = -1;
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] >= target) {
                ceil = arr[mid];
                high = mid - 1;
            } else low = mid + 1;
            
        }

        return ceil;
    }

    static int[] getFloorCeil(int arr[], int target) {
        int floor = floor(arr, target);
        if(floor == -1) return new int[] {-1, -1};

        return new int[] {floor, ceil(arr, target)};
    }
    public static void main(String[] args) {
        int arr[] = {3, 4, 4, 7, 8, 10};
        int target = 8;

        int ans[] = getFloorCeil(arr, target);
        System.out.println("Floor: " + ans[0] + " and Ceil: " + ans[1]);
    }
}
