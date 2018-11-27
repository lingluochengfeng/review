package chapter1.exercise1_1.exer_1_1_20;

/**
 * @author ASUS
 * @since 2018-11-25 14:01
 */
public class ComputeLg {
    public static void main(String[] args) {
        double result = factorialln(10);
        System.out.println(result);
    }

    public static double factorialln(long N){
        if (N > 1)
            return Math.log(N) + factorialln(N - 1);
        else
            return 0;
    }
}
