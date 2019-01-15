/**
 * 剪绳子
 * 题目：一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n > 1且m > 1）,
 * 每段绳子的长度记为k[0],k[1],....k[m]。请问k[0]*k[1]*...*k[m]可能的最大乘机是多少？
 * 例如：当绳子的长度是18时，我们把它剪成长度分别是2、3、3的三段，此时得到的最大乘机是18
 *
 * 该题目在牛客上没找到，没有进行测试
 * 参考博客：https://blog.csdn.net/upupday19/article/details/79315885
 */
public class Demo14 {
    //动态规划求解
    public int maxProductAfterCutting(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int[] products = new int[length + 1];
        //数组中第i个元素表示把长度为i的绳子剪成若干段之后各段长度的最大值
        //我觉得这里应该只是定义了基本的长度
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; ++i){
            max = 0;
            for (int j = 1; j <= i /2; ++j){
                int product = products[j] * products[i - j];
                if (max < product){
                    max = product;
                }
                //记录每一次的最大值
                products[i] = max;
            }
        }

        max = products[length];
        return max;
    }

    //贪心算法求解
    public int maxProductAfterCutting2(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = length / 3;

        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        //此时更好的方法是把绳子剪成长度为2的两段
        if (length - timesOf3 * 3 == 1){
            timesOf3 -= 1;
        }

        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) ((Math.pow(3,timesOf3)) * (Math.pow(2,timesOf2)));
    }
}
