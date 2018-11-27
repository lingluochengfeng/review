package chapter1.exercise1_1.exer_1_1_24;

/**
 * @author ASUS
 * @since 2018-11-25 14:10
 */
public class Divisor {
    public static int CommomDivisor(int x, int y){
        if (x == 1 || y == 1){
            System.out.println("x = " + x + "y = " + y);
            return 1;
        }
        if (x < y){
            int temp = x;
            x = y;
            y = temp;
        }
        if (x % y == 0){
            return y;
        }else {
            x = x % y;
            System.out.println("x = " + x);
            return CommomDivisor(x, y);
        }
    }
}
