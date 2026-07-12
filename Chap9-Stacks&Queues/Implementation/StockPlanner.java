import java.util.ArrayList;
import java.util.Stack;

class StockSpanners {
    Stack<int[]> stack;
    ArrayList<Integer> arrayList;
    int index;

    public StockSpanners() {
        stack = new Stack<>();
        arrayList = new ArrayList<>();
        index = 0;
    }
    
    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        int span;

        if (stack.isEmpty()) {
            span = index + 1;
        } else {
            span = index - stack.peek()[1];
        }

        stack.push(new int[]{price, index});
        index++;

        return span;
    }
}

public class StockPlanner {
    public static void main(String[] args) {
        StockSpanners stockSpanner = new StockSpanners();
        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80)); // 1
        System.out.println(stockSpanner.next(60)); // 1
        System.out.println(stockSpanner.next(70)); // 2
        System.out.println(stockSpanner.next(60)); // 1
        System.out.println(stockSpanner.next(75)); // 4
        System.out.println(stockSpanner.next(85)); // 6
    }
}
