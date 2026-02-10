import java.util.HashMap;

public class TwoSum {

    // Brute force (TC -> n2, SC -> 1)
    static int [] getIndexes(int arr [], int target) {

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {}; // return empty array if no solution found
    }

    // Better Approach  (TC-> nlogn, SC -> n)

    static int[] BetGetIndexes(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int more = target - arr[i];
            if(map.containsKey(more)) {

                return new int[] {i, map.get(more)};
            }

            map.put(arr[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int arr [] = {2,7,11,15};
        int target = 26;
        int answer[] = BetGetIndexes(arr, target);
        System.out.print(answer[0] + " " + answer[1]);
    }
}
