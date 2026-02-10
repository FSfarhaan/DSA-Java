class LeftRotateByOne {
    // brute force approach (TC -> 2n, SC -> n)
    static void leftRotate (int arr[]) {
        int temp[] = new int[arr.length];
        int first = arr[0];

        for(int i = 0; i < arr.length - 1; i++) {
            temp[i] = arr[i + 1];
        }

        temp[arr.length - 1] = first;

        for(int i = 0; i < temp.length; i ++) {
            System.out.print(temp[i] + " ");
        }
    }

    // better approach, (TC -> n, SC - > 1)
    static void bleftRotate(int arr[]) {
        int first = arr[0];

        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[arr.length - 1] = first;

        for(int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6};
        bleftRotate(arr);
    }
}