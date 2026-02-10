public class NextPermutation {

    static void reverseArr(int arr[]) {
        int n = arr.length;
        for(int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    // Optimal solution (TC -> )
    static void getNextPermutation(int arr[]) {
        int n = arr.length;
        int breakingIndex = -1;
        // Find The breaking point
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i + 1] > arr[i]) {
                breakingIndex = i;
                break;
            } 
        }

        System.out.println("Breaking index: " + breakingIndex);

        // Array is reversely sorted. Hence reverse it again and it is the answer.
        if(breakingIndex == -1) {
            reverseArr(arr);
            return;
        }

        // Find the minimum of the array and swap it with the breaking index.
        for(int j = n - 1; j >= 0; j--) {
            if(arr[j] > arr[breakingIndex]) {
                int temp = arr[j];
                arr[j] = arr[breakingIndex];
                arr[breakingIndex] = temp;
                break;
            }
        }
        

        // Reverse the entire right array.

        // Dry Run: 
        // index = 0; k = 1;
        
        int index = breakingIndex;
        for(int k = 1; k <= (n - breakingIndex) / 2; k++) {
            int temp = arr[index + 1];
            arr[index + 1] = arr[n - k];
            arr[n - k] = temp;
            index++;
        }

        for(int l = 0; l < n; l++) {
            System.out.print(arr[l] + " ");
        }
    }
    public static void main(String[] args) {
        int arr [] = {2, 1, 5, 4, 3, 0, 0};
        // {2, 3, 5, 4, 1, 0, 0}
        getNextPermutation(arr);
    }
}
