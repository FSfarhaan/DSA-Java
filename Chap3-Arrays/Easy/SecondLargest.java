import java.util.Arrays;

public class SecondLargest {
    // Brute force (works only if there is no duplicate of the highest and the lowest) 
    static void brutSecondLargeSmall(int arr[]) {
        Arrays.sort(arr);
        System.out.println("The Second largest element is: " + arr[arr.length - 2]);
        System.out.println("The Second smallest element is: " + arr[1]);
    }

    // Better approach
    static void betterSecondLargeSmall(int [] arr) {
        
        int largest = Integer.MIN_VALUE, slargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, ssmallest = Integer.MAX_VALUE;
        
        // First pass;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > largest) largest = arr[i];
            if(arr[i] < smallest) smallest = arr[i];
        }
        // Second pass;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > slargest && arr[i] != largest) slargest = arr[i];
            if(arr[i] < ssmallest && arr[i] != smallest) ssmallest = arr[i];
        }
        
        System.out.println("Largest is: " + largest);
        System.out.println("Second largest is: " + slargest);
        System.out.println("Smallest is: " + smallest);
        System.out.println("Second smallest is: " + ssmallest);
    }
    
    // Optimal Approach
    static void optSecondLargeSmall(int [] arr) {
        int largest = Integer.MIN_VALUE, slargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, ssmallest = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > largest) {
                slargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > slargest && arr[i] != largest) slargest = arr[i];

            if(arr[i] < smallest) {
                ssmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] < ssmallest && arr[i] != smallest) ssmallest = arr[i];
        }   
        
        System.out.println("Largest is: " + largest);
        System.out.println("Second largest is: " + slargest);
        System.out.println("Smallest is: " + smallest);
        System.out.println("Second smallest is: " + ssmallest);
    }

    public static void main(String[] args) {
        int [] arr = new int[]{ 2, 5, 5, 1, 3, 0 };
        // brutSecondLargeSmall(arr);
        // betterSecondLargeSmall(arr);
        optSecondLargeSmall(arr);
    }
}
