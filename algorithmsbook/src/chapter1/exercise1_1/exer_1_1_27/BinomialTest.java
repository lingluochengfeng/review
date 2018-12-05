package chapter1.exercise1_1.exer_1_1_27;

public class BinomialTest {
    public static double binomial(int N, int k, double p){
        if (N == 0 && k == 0){
            return 1.0;
        }
        if (N < 0 || k < 0){
            return 0.0;
        }
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    /**
     * 通过数组实现
     * @param N
     * @param k
     * @param p
     */
    public static void binomialArrays(int N, int k, double p){
        double[][] a = new double[N + 1][k + 1];
        a[0][0] = 1.0;
        for (int j = 1; j < N + 1; j++){
            a[j][0] = a[j - 1][0] * (1 - p);
        }
        for (int i = 0; i < N + 1; i++){
            for (int j = 0; j <= i && j < k + 1; j++){
                a[i][j] = (1 - p) * a[i - 1][j] + p * a[i - 1][j - 1];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(binomial(3, 3, 0.25));
    }
}
