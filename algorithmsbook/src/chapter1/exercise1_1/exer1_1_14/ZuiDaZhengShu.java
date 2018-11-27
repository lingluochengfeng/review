package chapter1.exercise1_1.exer1_1_14;

/**
 * 编写一个静态方法lg（），接受一个整型参数N，返回不大于log2N的最大整数
 * 不要使用Math库
 * @author ASUS
 * @since 2018-11-25 13:26
 */
public class ZuiDaZhengShu {
    public static void main(String[] args) {
        System.out.println(lg(9,3));
    }
    public static int lg(int N, int M){
        int a = 0;
        while (N > M){
            N = N / M;
            a++;
        }
        return a;
    }
}
