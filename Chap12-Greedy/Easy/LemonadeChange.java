public class LemonadeChange {

    static boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        
        for (int bill : bills) {
            switch (bill) {
                case 5 -> fives++;
                case 10 -> {
                    tens++;
                    if (fives > 0) {
                        fives--;
                    } else {
                        return false;
                    }
                }
                case 20 -> {
                    if (tens > 0 && fives > 0) {
                        tens--;
                        fives--;
                    } else if (fives >= 3) {
                        fives -= 3;
                    } else {
                        return false;
                    }
                }
                default -> {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = { 5,5,5,10,20 };
        System.out.println(lemonadeChange(bills));
    }
}
