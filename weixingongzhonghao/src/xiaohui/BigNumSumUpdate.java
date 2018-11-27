package xiaohui;

/**
 * 大整数求和
 * 1. 修改了代码中进位判断条件的bug，优化了部分代码的可读性
 * 2. 增加了JDK工具类BigInteger和BigDecimal的说明
 * 3. 补充了一个优化方法，即把大整数拆分成数组时，按十进制每9位拆分，而非每1位拆分
 * @author ASUS
 * @since 2018-11-24 17:19
 */
public class BigNumSumUpdate {

    public static void main(String[] args) {
        System.out.println(bigNumberSum("123224343423","231289732"));
    }

    public static String bigNumberSum(String bigNumberA, String bigNumberB){
        //1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumberA.length() > bigNumberB.length() ? bigNumberA.length() : bigNumberB.length();
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < bigNumberA.length(); i++){
            arrayA[i] = bigNumberA.charAt(bigNumberA.length() - 1 - i);
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length(); i++){
            arrayB[i] = bigNumberB.charAt(bigNumberB.length() - 1 - i);
        }
        //2.构造result数组，数组长度等于较大整数位+1
        int[] result = new int[maxLength + 1];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++){
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
            //判断是否进位
            if (temp > 10){
                temp = temp - 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder();
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--){
            if (!findFirst){
                if (result[i] == 0){
                    continue;
                }
                findFirst = true;
            }
            sb.append(result[i]);
        }

        return sb.toString();


    }


}
