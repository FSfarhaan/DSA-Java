public class MinPlatformsRequired {

    static int countPlatfrorms(int[] arr, int[] dep) {
        int ans = 1;

        for(int i = 0; i < arr.length; i++) {
            int count = 1;
            
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] >= arr[i] && arr[j] <= dep[i]) count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1020, 1200};
        int[] dep = {1050, 1230};

        System.out.println(countPlatfrorms(arr, dep));
    }
}
