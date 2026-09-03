
import java.util.Arrays;

class Item {
    int weight;
    int value;
    double wBv;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.wBv = (double) value / weight;
    }
}

public class FractionalKnapsack {

    static double fractionalKnapsack(int[] profit, int[] weight, int capacity) {
        Item[] items = new Item[profit.length];

        for(int i = 0; i < profit.length; i++) {
            items[i] = new Item(weight[i], profit[i]);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.wBv, a.wBv));

        // for(Item item: items) {
        //     System.out.println(item.value + " " +  item.weight + " " + item.wBv);
        // }
        
        double totalProfit = 0;
        int totalWeight = 0;

        for(Item item: items) {
            // System.out.println("Yaha pe profit itna hai: " + totalProfit);
            if(totalWeight + item.weight <= capacity) {
                totalProfit += item.value;
                totalWeight += item.weight;
            } else {
                totalProfit += item.wBv * (capacity - totalWeight);
                break;
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] profit = { 60, 100 };
        int[] weight = { 10, 20 };
        int capacity = 50;
        System.out.println(fractionalKnapsack(profit, weight, capacity));
    }
}
