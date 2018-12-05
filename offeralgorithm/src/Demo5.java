import java.util.Scanner;

/**
 * 替换空格
 * @author ASUS
 * @since 2018-09-30 17:22
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        StringBuffer str = new StringBuffer(s);

        String result = replaceSpace(str);
        System.out.println(result);
    }

    public static String replaceSpace(StringBuffer str){
        if (str == null || str.length() < 0){
            return str.toString();
        }

        //originalLength为字符串str的实际长度
        int originalLength = str.length();

        int numberOfBlank = 0;
        for (int i = 0; i < originalLength; i++){
            if (str.charAt(i) == ' '){
                numberOfBlank++;
            }
        }

        //newLength 为吧空格替换成'%20'之后的长度
        int newLength = originalLength + 2 * numberOfBlank;
        str.setLength(newLength);
        //指定两个指针
        int indexOfOriginal = originalLength - 1;
        int indexOfNew = newLength - 1;

        //开始复制
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
            if (str.charAt(indexOfOriginal) == ' '){
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }else {
                str.setCharAt(indexOfNew--, str.charAt(indexOfOriginal));
            }
            indexOfOriginal--;
        }

        return str.toString();
    }
}
