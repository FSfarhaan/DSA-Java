public class MinimumBitFlips {

    // Brute force
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
    public static void main(String[] args) {
        int start = 10, goal = 7;

        System.out.println(flipBits(start, goal));    
    }

}
