import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    static void spiralMatrix(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        List<Integer> list = new ArrayList<>();

        while(left <= right && top <= bottom) {
            // Left to right
            for(int j = left; j <= right; j++)
                list.add(matrix[top][j]);
            top++;
            
            // Top to bottom
            for(int j = top; j <= bottom; j++) 
                list.add(matrix[j][right]);
            right--;
            
            // Right to left
            if(top <= bottom) {
                for(int j = right; j >= left; j--) 
                    list.add(matrix[bottom][j]);
                bottom--;
            }
            
            // Bottom to top;
            if(left <= right) {
                for(int j = bottom; j >= top; j--)
                    list.add(matrix[j][left]);
                left++;
            }
        }

        for(int it: list) {
            System.out.print(it);
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        spiralMatrix(matrix);
    }
}