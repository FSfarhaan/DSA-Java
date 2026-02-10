public class Consecutive1s {

    static void findConsecutives(int [] arr) {
        int max = 0;
        int counter = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                counter++;
                max = Math.max(max, counter);
            } 
            else counter = 0;
        }

        System.out.println(max);

        
    }
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 1, 0, 1};

        findConsecutives(arr);
    }
}