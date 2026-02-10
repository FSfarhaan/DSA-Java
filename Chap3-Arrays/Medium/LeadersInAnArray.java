import java.util.ArrayList;
import java.util.Collections;

public class LeadersInAnArray {

    // Brute force (TC -> n2, SC -> n)
    static void getLeaders(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> leadersArray = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            boolean leader = true;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }

            if(leader) leadersArray.add(arr[i]);
        }

        for(int k = 0; k < leadersArray.size(); k++) {
            System.out.print(leadersArray.get(k) + " ");
        }
    }

    // Optimal approach (TC -> 2n, SC -> n)
    static void OptGetLeaders(int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = 0;
        for(int i = n - 1; i > 0; i--) {
            if(arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(ans);

        for(int k = 0; k < ans.size(); k++) {
            System.out.print(ans.get(k) + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = { 10, 22, 12, 3, 0, 6 };
        // getLeaders(arr);
        OptGetLeaders(arr);
    }
}
