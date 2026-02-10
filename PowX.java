public class PowX {
    static double myPow(double x, int n) {
        if(n == 0) return 1;
        
        if(n > 0) {
            if(n == 1) return x;
            return x * myPow(x, n - 1);
        } 

        // 2 / 2, -1
        // 2 / 2 / 2, 0
        
        return x / myPow(x, n - 1);

    }
    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}
