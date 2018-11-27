package chapter1.exercise1_1.exer1_1_13;

/**
 * @author ASUS
 * @since 2018-11-25 11:22
 */
public class ZhuanZhi {
    public static void main(String[] args) {

    }
    public static int[][] switchMartix(int[][] a, int row, int col){
        int[][] b = new int[col][row];
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                b[j][i] = a[i][j];
            }
        }
        return b;
    }
}
