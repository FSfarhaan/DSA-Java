import java.util.Arrays;

public class ShipCapacity {
    static int countShips(int arr[], int weight) {
        int ship = 1;
        int sumWeight = 0;
        // {5, 4, 5, 2, 3, 4, 5, 6 };
        // w = 6;
        // 5 + 0 > 6 -> f 
        // tw = 5;

        // 4 + 5 > 6 -> t
        // ship = 1
        // tw = 4

        // 5 + 4 > 6 -> t
        // ship = 2
        // tw = 5;

        // 2 + 5 > 6 -> t
        // ship = 3
        // tw = 2

        // 3 + 2 > 6 -> f
        // tw = 5
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] + sumWeight > weight) {
                ship++;
                sumWeight = arr[i];
                // System.out.println("Ship badha for i " + arr[i]);
            } else {
                sumWeight += arr[i];
                // System.out.println("Ship Nahi badha for i " + arr[i]);
            }
        }
        return ship;
    }

    // Brute force (TC -> n * (sum - max), SC -> 1);
    static int getShipCapacity(int arr[], int days) {
        int n = arr.length;
        int min = Arrays.stream(arr).max().getAsInt();
        int max = n * (n + 1) / 2;
        int ans = -1;

        for(int i = min; i <= max; i++) {
            int daysNeeded = countShips(arr, i);
            if(daysNeeded <= days) {
                return i;
            }

            // System.out.println("No of ships for i " + i + " are: " + ships);
        }

        return ans;
    }

    // Optimal Approach (TC -> n * log(sum - max), SC -> 1);
    static int OptGetShipCapacity(int arr[], int days) {
        // int n = arr.length;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();        

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int daysNeeded = countShips(arr, mid);
            if(daysNeeded <= days) {                
                high = mid - 1;
            } else low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1};
        int days = 4;

        // System.out.println("The answer is: "+ getShipCapacity(arr, days));
        System.out.println("The answer is: "+ OptGetShipCapacity(arr, days));

    }
}
