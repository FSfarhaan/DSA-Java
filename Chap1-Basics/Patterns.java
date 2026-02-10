public class Patterns {
    static void pattern1(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    static void pattern2(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    static void pattern3(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }
    }
    static void pattern4(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println(" ");
        }
    }
    static void pattern5(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = n; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    static void pattern6(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println(" ");
        }
    }
    static void pattern7(int n) {
        for(int i = 1; i <= n; i++) {

            // spaces
            for(int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // stars
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println(" ");
        }
    }
    static void pattern8(int n) {
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // stars
            for(int j = 0; j < 2 * n - 2*i - 1; j++) {
                System.out.print("*");
            }

            System.out.println(" ");
        }
    }
    static void pattern10(int n) {
        for(int i = 1; i <= 2*n - 1 ; i++) {
            int stars = i;
            if(i > n) stars = 2*n - i;
            for(int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
    static void pattern11(int n) {
        int flag = 1;
        for(int i = 1; i <= n; i++) {
            flag = (i) % 2;
            for(int j = 1; j <= i; j++) {
                System.out.print(flag + " ");
                flag = 1 - flag;
            }
            System.out.println();
        }
    }
    static void pattern12(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            // i 1, space 3. i 2 space 2, i 3 space 1, i 4 space 0
            for(int j = 1; j <= 2*(n - i); j++) {
                System.out.print(" ");
            }

            for(int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    static int pattern13b(int n) {
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max += i;
        }
        return max;
    }
    static void pattern13(int n) {

        // (1-> 1), (2 -> 1, 2, 3), (3-> 1, 2, 3, 4, 5, 6), (4 -> 1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 
        // 1,1
        // 2,3
        // 3,6
        // 4,10
        // 5,15
        // It is basically the sum of upto that number
        // int sum = 0;
        // for(int i = 1; i <= n; i++) {
        //     sum += i;
        // }

        // System.out.println(sum);

        int flag = 1;
        int j;
        for(int i = 1; i <= n; i++) {
            for(j = flag; j <= pattern13b(i); j++) {
                System.out.print(j + " ");
            }
            System.out.println();
            flag = j;
        }
    }
    static void pattern14(int n) {
        
        for(int i = 0; i < n; i++) {
            for(char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
    static void pattern15(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                System.out.print((char) (65 + j ));
            }
            System.out.println();
        }
    }
    static void pattern16(int n) {
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print((char) (65 + i ));
            }
            System.out.println();
        }
    }
    static void pattern17(int n) {
        for(int i = 1; i <= n; i++) {
            // Spaces
            for(int j = 1; j <= n - i; j ++) {
                System.out.print(" ");
            }

            for(int j = 0; j < i; j++) {
                System.out.print((char) (65 + j));
            }

            for(int j = 1; j < i ; j++) {
                System.out.print((char) (65 - j + i - 1));
            }

            System.out.println();
        }
    }   
    static void pattern18(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print((char) (65 + (n - 1) - (i - j)));         
            }
            System.out.println();
        }
    }
    static void pattern18b(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print((char) (65 + (n - 1) - (j - 1)));         
            }
            System.out.println();
        }
    }
    static void pattern19(int n) {
        for(int i = 1; i <= n; i++) {
            // for stars
            for(int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            // System.out.println();

            // for spaces
            for(int j = 1; j < i; j++) {
                System.out.print("    ");
            }

            // for stars
            for(int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
        pattern19b(n);
    }
    static void pattern19b(int n) {
        for(int i = 1; i <= n; i++) {
            // for stars
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // for spaces
            for(int j = 1; j <= n - i; j++) {
                System.out.print("    ");
            }

            // // for stars
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
    static void pattern20(int n) {
        for(int i = 1; i <= n; i++) {
            // for stars
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // for spaces
            for(int j = 1; j < n - i + 1; j++) {
                System.out.print("    ");
            }

            // for stars
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
        pattern20b(n);
    }
    static void pattern20b(int n) {
        for(int i = 2; i <= n; i++) {
            // for stars
            for(int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }
            // System.out.println();

            // for spaces
            for(int j = 1; j < i; j++) {
                System.out.print("    ");
            }

            // for stars
            for(int j = 1; j <= n - i + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
    static void pattern21(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        for(int i = 1; i <= n - 2; i++) {
            // for stars
            System.out.print("* ");

            // for spaces
            for(int j = 1; j <= n - 2; j++) {
                System.out.print("  ");
            }

            System.out.print("* ");
            System.out.println();
        }

        if(n == 1) return;
        for(int i = 1; i <= n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void main(String[] args) {        
        int n = 5;
        // System.out.println((char) (65 + 0));
        pattern17(n);
    }
}