
public class CompletePrimeNumber {
    static boolean isPrime(String s) {
        int n = Integer.parseInt(s);
        if(n == 1) return false;
        if(n == 2) return true;
        
        if(n % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;  
    };

    static boolean completePrime(int num) {
        String s = String.valueOf(num);

        for(int i = 0; i < s.length(); i++) {
            // for prefix
            if(!isPrime(s.substring(0, i+1))) return false;

            // for suffix
            else if(!isPrime(s.substring(i, s.length()))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int num = 39;
        System.out.println(completePrime(num));
        // 1, 12, 127, 1273
        // 3, 73, 273, 1273
        /* 0 -> 1
             -> 1273
           1 -> 12
             -> 273
           2 -> 127
             -> 73
           3 -> 1273
             -> 3
        */
    }
}
