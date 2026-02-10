public class StockBuyAndSell {

    // Brute force  (TC -> n2, SC -> 1);
    static void buyAndSell(int arr[]) {
        int n = arr.length;
        int max = 0;
        
        // buy = 7; sum 
        for(int i = 0; i < n; i++) {
            int buy = arr[i];
            for(int j = i + 1; j < n; j++) {
                int sell = arr[j];
                max = Math.max(max, sell - buy);
            }

        }
        System.out.println(max);
    }

    // Optimal Approach (TC -> n2, SC -> 1);
    static void OptBuyAndSell(int arr[]) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++ ) {
            minPrice = Math.min(minPrice, arr[i]);
            max = Math.max(max, arr[i] - minPrice);
        }

        System.out.println(max);
    }
    public static void main(String[] args) {
        int arr [] = { 7, 1, 5, 3, 6, 4 };
        // buyAndSell(arr);
        OptBuyAndSell(arr);
    }
}
