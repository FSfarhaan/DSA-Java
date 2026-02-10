import java.util.ArrayList;
import java.util.Collections;

public class AlternatePosNeg {

    // Brute force (TC -> 2n, SC -> n)
    static void alternate(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> posArray = new ArrayList<>(); 
        ArrayList<Integer> negArray = new ArrayList<>(); 

        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0) posArray.add(arr[i]);
            else negArray.add(arr[i]);
        }

        // int j = 0;
        // int min = Math.min(posArray.size(), negArray.size());

        // int posCount = 0, negCount = 0;
        // while(j < min) {
        //     if(j % 2 == 0) {
        //         arr[j] = posArray.get(posCount);
        //         posCount++;
        //     }
        //     else {
        //         arr[j] = negArray.get(negCount);
        //         negCount++;
        //     }
        //     j++;
        // } // 


        for(int j = 0; j < n / 2; j++) {
            arr[2*j] = posArray.get(j);
            arr[2*j + 1] = negArray.get(j);
        }
        
        for(int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    // Optimal approach - equals +ve and -ve (TC -> n, SC -> n);
    static void OptAlternative(int arr[]) {
        int n = arr.length;
        int [] ans = new int[n];

        int posIndex = 0, negIndex = 1;

        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                ans[negIndex] = arr[i];
                negIndex += 2;
            }
            else {
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }

        for(int k = 0; k < ans.length; k++) {
            System.out.print(ans[k] + " ");
        }
    }

    static void OptAlternative2(int arr[]) {
        int n = arr.length;
        
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> posArray = new ArrayList<>();
        ArrayList<Integer> negArray = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) negArray.add(arr[i]);
            else posArray.add(arr[i]);
        }

        if(posArray.size() < negArray.size()) {
            for(int j = 0; j < posArray.size(); j++) {
                ans.set(2*j, posArray.get(j));
                ans.set(2*j + 1, negArray.get(j));
            }

            int index = posArray.size() * 2;
            for(int k = posArray.size(); k < negArray.size(); k++) {
                ans.set(index++, negArray.get(k));
            }
            
        } else {
            for(int j = 0; j < negArray.size(); j++) {
                ans.set(2*j, posArray.get(j));
                ans.set(2*j + 1, negArray.get(j));
            }

            int index = negArray.size() * 2;
            for(int k = negArray.size(); k < posArray.size(); k++) {
                ans.set(index++, posArray.get(k));
            }
        }

        for(int k = 0; k < ans.size(); k++) {
            System.out.print(ans.get(k) + " ");
        }

    }
    public static void main(String[] args) {
        int arr[] = {1, 2, -3, -1, 4, -3};
        // alternate(arr);
        OptAlternative(arr);
    }
}
