import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    // Brute force (TC -> nlogn + 2n, SC -> n);
    static void mergeOverlapping(int arr[][]) {
        List<List<Integer>> arrayList = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
            
        });
        int n = arr.length;
        
        for(int i = 0; i < n; i++)  {
            int start = arr[i][0];
            int end = arr[i][1];

            if (!arrayList.isEmpty() && end <= arrayList.get(arrayList.size() - 1).get(1)) {
                continue;
            }

            for(int j = i + 1; j < n; j++) {
                if(arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else break;
            }
            
            arrayList.add(Arrays.asList(start, end));
            
        }

        for(List<Integer> list: arrayList) {
            for(int k : list) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    // Optimal Approach (TC -> nlogn + n, SC -> n);
    static void OptMergeOverlapping(int arr[][]) {
        List<List<Integer>> arrayList = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
            
        });
        int n = arr.length;

        for(int i = 0; i < n; i++) {

            if(arrayList.isEmpty() || arr[i][0] > arrayList.get(arrayList.size() - 1).get(1)) {
                arrayList.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                arrayList.get(arrayList.size() - 1).set(1, Math.max(arrayList.get(arrayList.size() - 1).get(1), arr[i][1]));
            }
        }

        for(List<Integer> list: arrayList) {
            for(int k : list) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        int arr[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        // mergeOverlapping(arr);
        OptMergeOverlapping(arr);
    }
}
