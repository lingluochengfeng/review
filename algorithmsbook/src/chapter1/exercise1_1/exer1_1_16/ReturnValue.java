package chapter1.exercise1_1.exer1_1_16;

/**
 * @author ASUS
 * @since 2018-11-25 13:42
 */
public class ReturnValue {
    public static String exR1(int n){
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }
}
