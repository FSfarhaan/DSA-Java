import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfTwoArrays {

    // Brute (TC -> (m+n) log (m+n) , SC -> 1 ) 
    static void findUnion(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int j = 0; j < arr2.length; j++) {
            set.add(arr2[j]);
        }

        for(int it: set) {
            System.out.print(it + " ");
        }
    }

    // Optimal !Sorted (TC -> m+n, SC -> 1)
    static void OptiUnion (int arr1[], int arr2[]) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size()-1) != arr1[i])
                    union.add(arr1[i]);
                i++;
            } else {
                if(union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        while(i < arr1.length) {
            if(union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
                i++;
            }
        }

        while (j < arr2.length) {
            if(union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
                j++;
            }
        }

        for(int k : union) {
            System.out.print(k + " ");
        }

    }
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {1, 2, 3, 4, 4, 5, 11, 12};

        OptiUnion(arr1, arr2);
    }
}
