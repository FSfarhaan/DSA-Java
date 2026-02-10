
public class FindMissingNumber {

    // Brute Force (TC -> n2 , SC -> 1)
    static void findMissing(int arr[]) {
        for(int i = 1; i < arr.length; i++) {

            int flag = 0;
            
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == i) {
                    flag = 1;
                    break;
                }   
            }

            if(flag == 0) {
                System.out.println("Missing number is: " + i);
                break;
            }
        }
    }

    // Better (TC -> 2n, SC -> n)
    static void BetFindMissing(int arr[]) {
        int hash[] = new int[arr.length + 1];

        for(int i = 0; i < arr.length - 1; i++) {
            hash[arr[i]]++;
        }

        for(int j = 1; j < arr.length; j++){
            if(hash[j] == 0) {
                System.out.println("Missing number is: " + j);
                break;
            }
        }
    }

    // Optimal 1 (TC -> n; SC -> 1) => Not recommended for a large value of n;
    static void OptFindMissing(int arr[]) {
        int n = arr.length;
        int summation = (n * (n + 1)) / 2;
        int total = 0;

        for(int i = 0; i < n; i++) {
            total += arr[i];
        }

        System.out.println("Missing number is: " + (summation - total));
    }

    // Optimal 2 (TC -> n, SC -> 1)
    static void OptFindMissing2(int arr[]) {
        int xor1 = 0, xor2 = 0;

        for(int i = 0; i < arr.length; i++) {
            xor1 = xor1 ^ arr[i];
            xor2 = xor2 ^ (i + 1);
        }

        xor2 = xor2 ^ (arr.length + 1);

        System.out.println(xor2 ^ xor1);
        // System.out.println(xor2);
    }
    public static void main(String[] args) {
        // int arr[] = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10};
        int arr[] = { 3, 0, 1};

        OptFindMissing(arr);
    }
}
