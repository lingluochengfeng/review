package chapter1.exercise1_1.exer1_1_7;

/**
 * @author ASUS
 * @since 2018-11-25 10:18
 */
public class PrintValue {
    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0 ;
        System.out.printf("%.5f\n",t);

        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);

        int sum1 = 0;
        for (int i = 1; i < 1000; i = i * 2)
            for (int j = 0; j < 1000; j++)
                sum1++;
        System.out.println(sum1);

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char)('a' + 4));

        Integer.toBinaryString(100);
    }
}
