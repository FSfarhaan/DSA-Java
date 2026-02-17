import java.util.ArrayList;

public class PerfectNumber {
    static ArrayList<Integer> getDivisorsB (int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        int sum = 0;
        for(int i = 1; i < Math.sqrt(n); i++) {
            if(n % i == 0) {
                divisors.add(i);
                sum += i;

                if(i != n / i) {
                    divisors.add(n / i);
                    sum += n/i;
                }
            }
        }
        
        System.out.println("Sum to ye hai: " + sum);
        boolean x = true, y = false;
        System.out.println(x && y);

        return divisors;
    }
    public static void main(String[] args) {
        int n = 28;
        ArrayList<Integer> ans = getDivisorsB(n);
        for(int it: ans) {
            System.out.print(it + " ");
        }
    }

}
