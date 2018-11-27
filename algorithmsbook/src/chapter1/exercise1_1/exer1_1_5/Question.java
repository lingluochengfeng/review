package chapter1.exercise1_1.exer1_1_5;

import java.io.RandomAccessFile;
import java.util.Random;

/**
 * @author ASUS
 * @since 2018-11-25 10:01
 */
public class Question {
    public static void main(String[] args) {
        //Math.random()产生一个[0.0,1.0]之间的数
        double x = Math.random() * 8;
        double y = Math.random() * 10;

        Random x1 = new Random(1);
        Random y1 = new Random(1);

        System.out.println(x);
        System.out.println(y);

        if ((x >= 0 && x <= 1) && (y >= 0 && y <= 1)){
            System.out.println("true");
        }else
            System.out.println("false");

    }
}
