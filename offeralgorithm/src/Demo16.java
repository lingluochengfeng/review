/**
 * 数值的整数次方
 * 题目：实现函数double Power(double base, int exponent),
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Demo16 {

    public static double power(double base, int exponent){
        if (equal(base,0.0) && exponent < 0)
            throw new RuntimeException("while exponent is minus, the base can't be zero");
        int absExponent = exponent;
        if (exponent < 0)
            //整数按位取反+1得到他的相反数
            absExponent = ~exponent + 1;
        //解法一
//        double result = powerByRecursion1(base, absExponent);
        //解法二
        double result = powerByRecursion2(base, absExponent);
        if (exponent < 0)
            result = 1.0 / result;
        return result;
    }

    //解法一：
    private static double powerByRecursion1(double base, int absExponent) {
        double result = 1.0;
        for (int i = 1; i <= absExponent; i++){
            result = result * base;
        }
        return result;
    }

    //解法二：计算一个数的乘方的时候，通过计算指数的一半次，得到的结果相乘即可得到，这样计算量会大大减少
    private static double powerByRecursion2(double base, int absExponent) {
        if (absExponent == 0)
            return 1.0;
        if (absExponent == 1)
            return base;
        double result = powerByRecursion2(base, absExponent >> 1);
        result = result * result;
        //判断是奇数还是偶数
        if ((absExponent & 0x1) == 1)
            result *= base;
        return result;
    }

    //浮点数由于精度问题不能用==判断是否想等，如果两数满足一定条件精度，可以看做相等
    private static boolean equal(double base, double v) {
        if (base - v > -0.0000001 && (base - v) < 0.0000001){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Demo16.power(64,-3));
    }
}



