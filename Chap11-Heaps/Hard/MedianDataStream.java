import java.util.Collections;
import java.util.PriorityQueue;

// Brutest Force
// class MedianFinder {
//     ArrayList<Integer> arr;
//     public MedianFinder() {
//         arr = new ArrayList<>();
//     }
    
//     // Nlogn for each adding. Means just for adding, we are using TC -> n * nlogn
//     public void addNum(int num) {
//         arr.add(num);
//         arr.sort(null);
//     }
    
//     // TC -> 1;
//     public double findMedian() {
//         int n = arr.size();
//         if(n % 2 == 1) return arr.get(n/2);
//         return (arr.get(n/2) + arr.get(n/2 - 1)) / 2.0;
//     }
// }



class MedianFinder {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if(maxheap.isEmpty() || num <= maxheap.peek()) maxheap.offer(num);
        else minheap.offer(num);

        if(maxheap.size() > minheap.size() + 1) minheap.offer(maxheap.poll());
        else if(minheap.size() > maxheap.size()) maxheap.offer(minheap.poll());
    }

    public double findMedian() {
        if(minheap.size() == maxheap.size()) {
            return (minheap.peek() + maxheap.peek()) / 2.0;
        }
        return maxheap.peek();
    }
}

public class MedianDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());      // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian());      // return 2.0
    }
}