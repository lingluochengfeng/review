package chapter1.exercise1_1.exer1_1_3;

import java.util.Scanner;

/**
 * 从命令行得到三个整数参数，如果都相等，打印equal，否则打印not equal
 * @author ASUS
 * @since 2018-11-25 10:00
 */
public class ThreeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] temp = s.split(" ");

        if (Integer.parseInt(temp[0]) == Integer.parseInt(temp[1])
                && Integer.parseInt(temp[1]) == Integer.parseInt(temp[2])){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }
}
