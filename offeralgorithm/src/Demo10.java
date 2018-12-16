/**
 * 斐波那契数列
 * 题目：求斐波那契数列的第n项
 * 写一个函数，输入n，求斐波那契(Fibonacci)数列的第n项。
 * @author ASUS
 * @since 2018-12-13 20:19
 */
public class Demo10 {
    public long Fibonacci(int n){

        int result = 0;
        int preOne = 1;
        int preTwo = 0;

        if (n == 0){
            return preTwo;
        }

        if (n == 1){
            return preOne;
        }

        for (int i = 2; i <= n; i++){
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
