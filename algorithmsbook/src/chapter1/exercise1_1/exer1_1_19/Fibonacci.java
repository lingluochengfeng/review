package chapter1.exercise1_1.exer1_1_19;

/**
 * @author ASUS
 * @since 2018-11-25 13:55
 */
public class Fibonacci {
    public static long F(int N){
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return F(N - 1) + F(N - 2);
    }

    public static void main(String[] args) {
        for (int N = 0; N < 10; N++){
            System.out.println(N + " " + F(N));
        }

        int[] arr = new int[100];
        A(arr);
    }

    private static void A(int[] arr) {
        arr[0] = 0;
        arr[1] = 1;
        for (int N = 2; N < 100; N++){
            arr[N] = arr[N - 1] + arr[N - 2];
            System.out.println(N + " " + arr[N]);
        }
    }
}
