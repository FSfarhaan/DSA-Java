import java.util.HashSet;

public class RemoveDuplicates {

    // Brute Force
    static void brutRemDuplicate(int [] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int j = 0;
        for(int x: set) {
            arr[j++] = x;
        }
        
        System.out.println("The new array is: ");
        for(int k = 0; k < set.size(); k++) {
            System.out.print(arr[k] + " ");
        }
    }

    // Optimal Approach (Using two pointers)
    static void optRemDuplicates(int arr[]) {
        int index = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[index]) {
                arr[index + 1] = arr[i];
                index++;
            }
        }

        System.out.println("The new array is: ");
        for(int i = 0; i <= index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int [] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 6};
        // brutRemDuplicate(arr);
        optRemDuplicates(arr);
    }
}
