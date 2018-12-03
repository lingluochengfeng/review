package xiaohui.bignumsum;

/**
 * 大整数求和
 * 时间复杂度和空间复杂度都是:O(N)
 *
 * 评论区提到可以用万进制优化
 * @author ASUS
 * @since 2018-11-24 16:45
 */
public class BigNumSum {

    /**
     * 大整数求和
     * @param bigNumberA
     * @param bigNumberB
     * @return
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB){
        //1.将两个大整数用数组逆序存储
        char[] charsA = new StringBuffer(bigNumberA).reverse().toString().toCharArray();
        char[] charsB = new StringBuffer(bigNumberB).reverse().toString().toCharArray();
        //2.构建result数组，数组长度等于较大整数数位+1
        int maxLength = charsA.length > charsB.length ? charsA.length : charsB.length;
        int[] result = new int[maxLength];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++){
            int temp = result[i];
            if (i < charsA.length){
                //把char类型的数字字符转成对应的整形
                temp += charsA[i] - '0';
            }
            if (i < charsB.length){
                //把char类型的数字字符转成对应的整形
                temp += charsB[i] - '0';
            }
            //判断是否进位
            if (temp >= 10){
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = result.length - 1; i >= 0; i--){
            if (result[i] == 0 && flag){
                continue;
            }
            flag = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(bigNumberSum("123","564"));
    }
}
