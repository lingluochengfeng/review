package chapter1.exercise1_1.exer1_1_11;

/**
 * @author ASUS
 * @since 2018-11-25 10:39
 */
public class TestTrueOrFalse {
    public static void main(String[] args) {
        boolean[][] a = new boolean[4][3];

        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 3;col++)
                a[row][col] = (row + col) % 2 == 0;
        //打印列号
        System.out.println(" ");
        for (int col = 0; col < 3; col++){
            System.out.printf(" %d",col);
        }
        System.out.println("");

        //打印行号和数组元素的值
        for (int row = 0; row < 4; row++){
            System.out.printf("%d",row);
            for (int col = 0; col < 3; col++){
                if (a[row][col])
                    System.out.printf(" *");
                else
                    System.out.printf(" ");
            }
            System.out.println();
        }
    }


}
