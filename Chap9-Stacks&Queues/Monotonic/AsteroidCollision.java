import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    // With stack (TC -> n, SC -> n);
    static int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int x = arr[i];
            if(x > 0) stack.push(x);
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(x)) {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) stack.push(x);
                else if(Math.abs(x) == stack.peek()) stack.pop();
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    // With array
    static int[] asteroidCollisionArr(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int x = arr[i];

            if(x > 0) ans.add(x);
            else {
                
                while (!ans.isEmpty() && ans.get(ans.size() - 1) < Math.abs(x)) {
                    ans.remove(ans.size() - 1);
                }
                if(ans.isEmpty()) ans.add(x);
                else if(Math.abs(x) == ans.get(ans.size() - 1)) ans.remove(ans.size() - 1);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] arr = { 5,10,-5 };

        int[] ans = asteroidCollision(arr);

        for(int k: ans) {
            System.out.print(k + " ");
        }
    }
}
 