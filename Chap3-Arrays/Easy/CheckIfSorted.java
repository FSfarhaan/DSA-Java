
public class CheckIfSorted {
    // Optimal force
    static void brutIsSorted(int arr[]) {
        boolean flag = true;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]) {
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("Sorted");
        else System.out.println("Not sorted");
    }
    public static void main(String[] args) {
        int [] arr = new int[]{ 1, 2, 3, 4, 2, 5, 6 };
        brutIsSorted(arr);
    }
}
