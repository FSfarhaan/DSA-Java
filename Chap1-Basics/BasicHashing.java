import java.util.HashMap;
import java.util.Map;

public class BasicHashing {
    static HashMap<Integer, Integer> frequencies (int [] nums) {
        // int result[] = new int[nums.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num: nums) {
            if(hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }   
        }
        return hashMap;
    }

    static HashMap<Integer, Integer> highestLowestFreq (int [] nums) {
        // int result[] = new int[nums.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for(int num: nums) {
            if(hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }   
        }
        
        int maxFreq = 0, minFreq = nums.length;
        int maxEle = 0, minEle = 0;
        for(Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if(count < minFreq) {
                minEle  = element;
                minFreq = count;
            }

            if(count > maxFreq) {
                maxFreq = count;
                maxEle = element;
            }
        }

        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);

        // result.put(maxEle, maxFreq);
        // result.put(minEle, minFreq);

        return hashMap;
    }

    
    public static void main(String[] args) {
        int arr[] = {10,5,10,15,10,5};
        // HashMap<Integer, Integer> result = frequencies(arr);
        // for(Map.Entry<Integer, Integer> entry : result.entrySet()) {
        //     System.out.println(entry.getKey() + " " + entry.getValue());
        // }

        highestLowestFreq(arr);
    }
}
