import java.util.ArrayList;

public class GenerateAllSubsequences {
    static void generateSS(int arr[], int index, ArrayList<Integer> ds) {
        if(index == arr.length) {
            for(int it: ds) {
                System.out.print(it);
            } 
            System.out.println();
            return;
        }

        ds.add(arr[index]);
        generateSS(arr, index+1, ds);

        ds.remove(ds.size()-1);
        generateSS(arr, index+1, ds);
    }


    static void generateSSWithSumk(int arr[], int index, ArrayList<Integer> ds, int sum, int s) {
        if(index == arr.length) {
            if(s == sum) {
                for(int it: ds) {
                    System.out.print(it + " ");
                }
                System.out.println();
            }
            return;
        }

        ds.add(arr[index]);
        s += arr[index];
        generateSSWithSumk(arr, index+1, ds, sum, s);

        ds.remove(ds.size() - 1);
        s -= arr[index];
        generateSSWithSumk(arr, index+1, ds, sum, s);

    }

    static boolean generateFirstSSOfSumK(int arr[], int index, ArrayList<Integer> ds, int sum, int s) {
        if(index == arr.length) {
            if(s == sum) {
                for(int it: ds) {
                    System.out.print(it + " ");
                }
                return true;
            } 
            return false;
        }

        ds.add(arr[index]);
        s += arr[index];

        if(generateFirstSSOfSumK(arr, index+1, ds, sum, s) == true) {
            return true;
        }

        ds.remove(ds.size() - 1);
        s -= arr[index];

        if(generateFirstSSOfSumK(arr, index+1, ds, sum, s) == true) {
            return true;
        }

        return false;
    }

    static int countSSOfSumK(int arr[], int index, ArrayList<Integer> ds, int sum, int s) {
        if(index == arr.length) {
            if(s == sum) {
                return 1;
            }
            return 0;
        }

        ds.add(arr[index]);
        s += arr[index];
        int left = countSSOfSumK(arr, index+1, ds, sum, s);

        ds.remove(ds.size() - 1);
        s -= arr[index];

        int right = countSSOfSumK(arr, index+1, ds, sum, s);

        return left + right;
    }
    public static void main(String[] args) {
        int arr[] = { 2,5,2,1,2 };
        int k = 5;
        ArrayList<Integer> list = new ArrayList<>();
        // generateSS(arr, 0, list);
        generateSSWithSumk(arr, 0, list, k, 0);
        // generateFirstSSOfSumK(arr, 0, list, k, 0);
        // System.out.println(countSSOfSumK(arr, 0, list, k, 0));
    }
}
