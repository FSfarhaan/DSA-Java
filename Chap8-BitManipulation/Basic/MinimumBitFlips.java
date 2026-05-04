public class MinimumBitFlips {

    // Brute force (TC -> 2logn + k, SC -> k);
    static int flipBits(int start, int goal) {
        
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);
        int count = 0;
    

        String buf = "";
        if(s.length() != g.length()) {
            if(s.length() > g.length()) {
                for(int i = 1; i <= s.length() - g.length(); i++) {
                    buf += "0";
                }
                g = buf + g;
            } else {
                for(int i = 1; i <= g.length() - s.length(); i++) {
                    buf += "0";
                }
                s = buf + s;
            }
        }


        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != g.charAt(i)) count++;
        }

        return count;
    }
    
    static int OptMinFlipBits(int start, int goal) {
        int n = start ^ goal;
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int start = 13, goal = 8;

        System.out.println(OptMinFlipBits(start, goal));
    }

}
