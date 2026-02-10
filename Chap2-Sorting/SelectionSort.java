class SelectionSort { 
    // min = 0

    static void selectSort(int [] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[]  = { 13, 46, 24, 52, 20, 9 };

        System.out.println("Before Sorting");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectSort(arr);
        System.out.println();
        System.out.println("After Sorting");
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }
}