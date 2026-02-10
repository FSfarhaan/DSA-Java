public class BouquertsOfRose {

    static int getMaxEle(int arr[]) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    static int getMinEle(int arr[]) {
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    static int getBouqets(int arr[], int day, int minAdjFlowers) {
        // arr[i] <= i ? adj += 1; -> adj == 3 ? bouqets += 1 : adj != 3 continue;
        // : arr[i] > i ? adj = 0;
        int bouqets = 0;
        int adj = 0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] <= day) {
                adj += 1;
                if(adj == minAdjFlowers) {
                    bouqets += 1;
                    adj = 0;
                }
            } else {
                adj = 0;
            }
        }
        return bouqets;
    }

    // Brute Force (TC -> n * (max - min) + 2n, SC -> 1);
    static int getMinDays(int arr[], int minBouquets, int minAdjFlowers) {
        
        // if total flowers required is less than flowers given (arr.length), we can return -1;
        int totalFlowersRequired = minBouquets * minAdjFlowers;
        if(totalFlowersRequired > arr.length) return -1;
        
        int max = getMaxEle(arr);
        int min = getMinEle(arr);
        int result = -1;

        for(int i = min; i <= max; i++) {
            int bouqetsFormed = getBouqets(arr, i, minAdjFlowers);
            // System.out.println("For day " + i + " Bouqets formed are " + bouqetsFormed);

            if(bouqetsFormed >= minBouquets) {
                result = i;
                break;
            }
        }
        return result;
    }

    // Optimal Approach (TC -> n * log(max - min), SC -> 1);
    static int OptGetMinDays(int arr[], int minBouquets, int minAdjFlowers) {
        int totalFlowersRequired = minBouquets * minAdjFlowers;
        if(totalFlowersRequired > arr.length) return -1;
        int low = getMinEle(arr), high = getMaxEle(arr);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int bouqetsFormed = getBouqets(arr, mid, minAdjFlowers);

            if(bouqetsFormed >= minBouquets) {
                high = mid - 1;
                result = mid;
            } else low = mid + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7,7,7,7,12,7,7};
        int minBouquets = 2, minAdjFlowers = 3;
        // System.out.println("The min days required are: " + getMinDays(arr, minBouquets, minAdjFlowers));
        System.out.println("The min days required are: " + OptGetMinDays(arr, minBouquets, minAdjFlowers));
    }
}
