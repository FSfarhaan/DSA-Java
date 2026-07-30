public class CheckArrayIsMinHeap {

    static int Left(int i) {
        return  2 * i + 1;
    }

    static int Right(int i) {
        return 2 * i + 2;
    }

    static boolean checkArr(int[] arr) {
        int n = arr.length;
        for(int i = 0; i <= (n / 2) - 1; i++) {
            int left = Left(i);
            int right = Right(i);

            if(left >= n && right >= n) break;

            if(!(arr[i] < arr[left] && arr[i] < arr[right])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 21, 23 };
        System.out.println(checkArr(arr));
    }
}
