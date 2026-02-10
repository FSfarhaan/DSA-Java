public class LargestOddNumber {
    static String getLargestOdd(String s) {
       for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            if (digit % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String s= "7542351161";
        System.out.println(getLargestOdd(s));
    }   
}
