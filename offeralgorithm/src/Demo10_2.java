/**
 * 题目二：青蛙跳台问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author ASUS
 * @since 2018-12-16 21:41
 */
public class Demo10_2 {
    public static int Fibnacci2(int n){
        int f1 = 1;
        int f2 = 2;
        int result = 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        for (int i = 3; i <= n; i++){
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
}
