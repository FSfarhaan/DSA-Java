public class LinearSearch {
    static void linearSearch(int arr[], int key) {
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        linearSearch(arr, 10);
    }
}
