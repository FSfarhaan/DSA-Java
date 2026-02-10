import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // Given row and col, give the element at that position
    static void variation1(int n, int r) {
        n--; r--;
        // Perform (n-1)C(r-1) 7c3
        /* 7!
           3!4!
           7 x 6 x 5
           1 x 2 x 3
        */

        long res = 1;
        for(int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        System.out.println("Element is:  " +  res);
    }

    // Print the row;
    static List<Integer> variation2(int row) {
        int n = row;
        // 5th row
        /* 
           1 4   6     4      1
           1 4   4*3   4*3*2  4*3*2*1 
             1   1*2   1*2*3  1*3*2*4
        */
        int res = 1;

        List<Integer> list = new ArrayList<>();
        list.add(res);

        for(int i = 1; i < n; i++) {
            res = res * (n - i);
            res = res / (i);

            list.add(res);
        }

        return list;
    }
    

    // Print the entire pascal triangle upto that row (TC -> n2, SC -> 1)
    static void variation3 (int row) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 1; i <= row; i++) {
            list.add(variation2(i));
        }

        for(List<Integer> it: list) {
            for(int el : it) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // variation1(5, 3);
        // variation2(6);
        variation3(6);
    }
}
