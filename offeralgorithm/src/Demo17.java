/**
 * 打印从1到最大的n位整数
 * 题目：输入数字n，按顺序打印从1到最大的n位十进制数。
 * 比如输入3，则打印出1、2、3一直到最大的3位数999
 */
public class Demo17 {
    //思路一：最简单的方法，先找出最大的n位数，然后循环打印即可
    public static void print1ToMaxOfNDigits_1(int n){
        int number = 1;
        int i = 0;
        while (i < n){
            number = number * 10;
            i++;
        }

        for (int j = 1; j < number; j++){
            System.out.print(j + " ");
        }
    }

    /**
     * 当数字很大时，int甚至是long类型都不能够满足大数的范围
     * 此时我们要用其他数据结构来存储数字
     */
    //思路二：使用字符串来存储数字
    public static void print1ToMaxOfNDigits_2(int n){
        if (n <= 0){
            return;
        }
        //StringBuffer是线程安全的，StringBuilder是非线程安全的，速度比较StringBuilder > StringBuffer > String
        StringBuffer number = new StringBuffer();

        for (int i = 0; i < n; i++){
            number.append('0');
        }

        while (!Increment(number)){
            PrintNumber(number);
        }
    }

    private static void PrintNumber(StringBuffer s) {
        boolean isBeginning0 = true;
        for (int i = 0; i < s.length(); i++){
            if (isBeginning0 && s.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if (!isBeginning0){
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();
    }

    /**
     * 要注意increment的终止条件
     * 打印函数：要注意处理前面的'0'字符
     * @param s
     * @return
     */
    private static boolean Increment(StringBuffer s) {
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int nLength = s.length();
        for (int i = nLength - 1; i >= 0; i--){
            int nSum = s.charAt(i) - '0' + nTakeOver;
            if (i == nLength - 1){
                nSum++;
            }
            if (nSum >= 10){
                if (i == 0){
                    isOverFlow = true;
                }else {
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char) ('0' + nSum));
                }
            }else {
                s.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverFlow;
    }

    /**
     * 思路三：用数字排列的方法表示：
     * 如果我们在数字前面补'0'的话，会发现n位所有的十进制数就是n个0到9的全排列
     * 也就是说
     * 我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。
     * 注意：打印的时候，要把前面的0补位去掉
     */
    public static void print1ToMaxOfNDigits_3(int n){
        if (n < 0){
            return;
        }

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < n; i++){
            s.append('0');
        }
        for (int i = 0; i < 10; i++){
            s.setCharAt(0, (char) (i + '0'));
            print1ToMaxOfNDigits_3_Recursely(s, n, 0);
        }
    }

    private static void print1ToMaxOfNDigits_3_Recursely(StringBuffer s, int n, int index) {
        if (index == n - 1){
            PrintNumber(s);
            return;
        }
        for (int i = 0; i < 10; i++){
            s.setCharAt(index + 1, (char) (i + '0'));
            print1ToMaxOfNDigits_3_Recursely(s, n, index + 1);
        }
    }


    public static void main(String[] args) {
        Demo17.print1ToMaxOfNDigits_3(2);
    }
}
