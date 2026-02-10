import java.util.PriorityQueue;

class Pair {
    double distance;
    int index;
    
    public Pair(double distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}

public class GasStations {

    // Brute force (TC -> k * n + n, SC -> n - 1)
    static double getDistance(int arr[], int k) {
        int n = arr.length;
        int howMany[] = new int[n - 1];

        
        // Place each gas station
        for(int i = 1; i <= k; i++) {
            double maxSection = -1;
            int maxInd = -1;
            for(int j = 0; j < n - 1; j++) {
                double diff = arr[j+1] - arr[j];
                double sectionLength = diff / (howMany[j] + 1.0);
                if(sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = j;
                }
            }
            howMany[maxInd]++;
        }
        double maxSection =-1;

        // Find the final max section length after placing all gas stations
        for(int i = 0; i < n - 1; i++) {
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff / (howMany[i] + 1.0);
            maxSection = Math.max(maxSection, sectionLength);

        }
        return maxSection;
    }

    // Better Approach (TC -> nlong + klogn, SC -> n-1 for storing howMany, n-1 for storing in queue);
    static double BetGetDistance(int arr[], int k) {
        int n = arr.length;
        int howMany[] = new int[n - 1];

        // Define a priority queue
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2.distance, o1.distance));

        // Add starting segments
        for(int i = 0; i < n - 1; i++) {
            queue.add(new Pair(arr[i+1] - arr[i], i));
        }

        // Add stations
        for(int i = 1; i <= k; i++) {
            Pair top = queue.poll();
            int index = top.index;

            howMany[index]++;
            double totalDist = arr[index + 1] - arr[index];
            double newDist = totalDist / (howMany[index] + 1);
            queue.add(new Pair(newDist, index));
        }
        return queue.peek().distance;
    }

    static double getGasDistance(int arr[], double distance) {
        int n = arr.length;
        double gasStations = 0;
        
        for(int i = 0; i < n - 1; i++) {
            double numberInBetween = ((arr[i+1] - arr[i]) / distance);
            if(arr[i+1] - arr[i] == distance * numberInBetween) numberInBetween--;
            gasStations += numberInBetween;
        }
        return gasStations;
    }

    // Optimal Approach
    static double OptGetDistance (int arr[], int k) {
        double low = 0.0, high = 0.0;

        for(int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, arr[i+1] - arr[i]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            double gasStations = getGasDistance(arr, mid);
            if(gasStations <= k) high = mid;
            else low = mid;
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}, k = 4;

        // System.out.println("The minimum distance is: "+ getDistance(arr, k));
        // System.out.println("The minimum distance is: "+ BetGetDistance(arr, k));
        System.out.println("The minimum distance is: "+ OptGetDistance(arr, k));


    }
}
