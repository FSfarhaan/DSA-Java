// > n / 3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MajorityElement {

    // Brute force (TC -> n2, SC -> 1);
    static void getMajority(int arr[]) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();

        int majority = (int) n / 3;
        for(int i = 0; i < n; i++) {
            int el = arr[i];
            int counter = 0;
            for(int j = 0; j < n; j++) {
                if(arr[j] == el) {
                    counter++;
                }
            }
            if(counter > majority) {
                set.add(arr[i]);
            }
            if(set.size() == 2) break;
        }

        for(int k : set) {
            System.out.print(k + " ");
        }
    }

    // Better approach (TC -> nlogn, SC -> n)
    static void BetGetMajority(int arr[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = arr.length;
        int majority = n / 3;

        for(int i = 0; i < n; i++) {
            int val = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], val+1);
        } 

        for(int j = 0; j < hashMap.size(); j++) {
            if(hashMap.get(arr[j])  > majority) {
                System.out.print(arr[j] + " ");
            }
        }
    }

    // Optimal Approach (TC -> n, SC -> 1)
    static void OptGetMajority(int arr[]) {
        List<Integer> list = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            if(count1 == 0 && el2 != arr[i]) {
                count1 = 1;
                el1 = arr[i];
            } else if(count2 == 0 && el1 != arr[i]) {
                count2 = 1;
                el2 = arr[i];
            } else if (arr[i] == el1) count1++;
              else if (arr[i] == el2) count2++;
            else  {
                count1--; count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == el1) count1++;
            if(arr[i] == el2) count2++;
        }

        int majority = (int) (n / 3) + 1;
        if(count1 >= majority) list.add(el1);
        if(count2 >= majority) list.add(el2);
        
        for(int k : list) {
            System.out.println(k + " ");
        }

    }
    public static void main(String[] args) {
        int arr[] = {3,2,3};
        // getMajority(arr);
        // BetGetMajority(arr);
        OptGetMajority(arr);
    }
}
