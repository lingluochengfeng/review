package chapter1.exercise1_1.exer_1_1_30;

/**
 * @author ASUS
 * @since 2018-12-04 21:42
 */
public class MatrixTest {
    public static boolean[][] TestArrays(boolean[][] arr){
        int N = arr.length;
        int M = arr[0].length;
        System.out.println("M = " + M + ", N = " + N);
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (gcd(i,j) == 1){
                    arr[i][j] = true;
                }else {
                    arr[i][j] = false;
                }
            }
        }
        return arr;
    }
    public static int gcd(int m, int n){
        if (m == 0 && n == 0){
            return 1;
        }
        if (m % n == 0){
            return n;
        }else {
            return gcd(n, m % n);
        }
    }
}
