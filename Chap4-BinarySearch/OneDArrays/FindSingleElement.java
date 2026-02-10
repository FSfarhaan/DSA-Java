

public class FindSingleElement {
    static void findElement(int arr[]) {
        int low = 0, high = arr.length - 1;
        if(arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("Mid: " + mid);
            if((mid + 1 < arr.length && mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid -1])) {
                low = mid + 1;
                System.out.println("Low: "  + low);
            } else {
                high = mid - 1;
                System.out.println("High: " + high);
            }
        }

        System.out.println(arr[low]);
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2};
        findElement(arr);
    }
}
