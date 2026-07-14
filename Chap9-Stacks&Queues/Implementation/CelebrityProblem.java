public class CelebrityProblem {

    // Brute force (TC -> n2, SC -> 1);
    static int findCelebrity(int[][] arr) {
        int n = arr.length - 1;
        int m = arr[0].length;

        for(int i = 0; i < n; i++) {
            Boolean canBeCelebrity = true;
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    canBeCelebrity = false;
                    break;
                }
            }
            if(canBeCelebrity) return i;
        }

        return -1;
    }

    static int OptFindCelebrity(int[][] arr) {
        int start = 0;
        int end = arr.length;
        
        while (start < end) {
            if(arr[start][end] == 1) start++;
            else if(arr[end][start] == 1) end--;
            
            else {
                start++; end--;
            }
        }

        if(start > end) return -1;

        for(int i = 0; i < arr.length; i++) {
            if(i == start) continue;

            if(arr[start][i] == 1 || arr[i][start] == 1) return -1;
        }

        return start;
    }

    public static void main(String[] args) {
        int[][] arr = { 
            {0, 1, 1, 0}, 
            {0, 0, 0, 0}, 
            {1, 1, 0, 0}, 
            {0, 1, 1, 0}
        };

        System.out.println(findCelebrity(arr));


    }
}
