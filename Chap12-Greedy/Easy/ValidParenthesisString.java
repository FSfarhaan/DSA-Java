public class ValidParenthesisString {

    // Wrong
    static boolean checkValidString(String s) {
        
        int stBracks = 0;
        int stars = 0;
        
        for(char c: s.toCharArray()) {
            if(c == '(') stBracks++;
            else if(c == ')') {
                if(stars == 0 && stBracks == 0) return false;

                if(stBracks > 0) {
                    stBracks--;
                } else {
                    stars--;
                }
            }
            else stars++;
        }

        System.out.println(stBracks);
        System.out.println(stars);

        return stars - Math.abs(stBracks) >= 0;
    }

    // Correct
    static boolean checkValidStringC(String s) {
        int minBracks = 0;
        int maxBracks = 0;

        for(char c: s.toCharArray()) {
            if(c == '(') {
                minBracks++; maxBracks++;
            } else if(c == ')') {
                minBracks--; maxBracks--;
            } else  {
                minBracks--; maxBracks++;
            }

            if(maxBracks < 0) return false;

            minBracks = Math.max(minBracks, 0);
        }

        return minBracks == 0;
    }

    public static void main(String[] args) {
        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(checkValidStringC(s));
    }
}
