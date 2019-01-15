import jdk.nashorn.internal.ir.IfNode;

/**
 * 题目：请实现一个函数，输入一个整数，输出该二进制表示中1的个数。
 * 例如，把9表示成二进制是1001，有2位是1。因此，如果输入9，则该函数输出2
 */
public class Demo15 {

    public int numberOf1(int n){
        int count = 0;

        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 判断一个整数是不是2的整数次方
     * @param n
     * @return
     */
    public boolean is2(int n){
        n = n & n - 1;
        if (n == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Demo15 demo15 = new Demo15();
        int i = demo15.numberOf1(7);
        System.out.println(i);
        System.out.println(demo15.is2(8));
    }

}
