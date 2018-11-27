package chapter1.exercise1_1.exer1_1_6;

/**
 * @author ASUS
 * @since 2018-11-25 10:15
 */
public class PrintWhat {

    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++){
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

}
