import java.util.ArrayList;

public class MoveZerosToEnd {

    // Brute force
    static void moveZeros(int arr[]) {
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) temp.add(arr[i]);
        }

        for(int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        for(int j = temp.size(); j < arr.length; j++) {
            arr[j] = 0;
        }

        for(int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }

        
    }

    // Optimal (TC -> n; SC -> 1)
    static void OptiMoveZeros(int arr[]) {
        int i = 0, j = 1;
        while(j < arr.length) {
            if(arr[j] != 0 && arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            if(arr[i] != 0) i++;
            j++;
        }

        // i = 1; j = 2;
        // { 1, 2, 0}

        for(int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {0,1,0,3,12};
        // arr = { 1, 2, 3,     2, 4, 5, 1, 0, 0, 0 }
        OptiMoveZeros(arr);
    }
}
