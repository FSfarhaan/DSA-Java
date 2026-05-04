public class CheckIthBitIsSet {

    // convert dec to bin
    static String decToBin(int dec) {
        String bin = "";
        while (dec != 0) {
            
            bin = bin + String.valueOf(dec % 2);
            dec = dec / 2;
        }
        // return revString(bin);
        return bin;
    }

    // Brute force (TC -> logn, SC -> logn);
    static boolean checkBit(int num, int i) {
        String bin = decToBin(num);

        System.out.println("Bin to ye hai: " + bin);

        if(bin.charAt(i) == '1') return true;
        return false;
    }

    // Optimal approach (TC -> 1, SC -> 1)
    static boolean OptCheckBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {
        int n = 9, i = 2;
        System.out.println(OptCheckBit(n, i));
    }
}
