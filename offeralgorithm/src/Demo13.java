/**
 * 机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，
 * 它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如：当k为18时，机器人能够进入方格(35,37)，因为3+5+3+7=18。但它不能进入方格（35，38）
 * 因为3+5+3+8=19。请问该机器人能到达多少个格子？
 * 参考网址：https://blog.csdn.net/gogokongyin/article/details/51788291（题目没理解，要仔细读题，不要着急）
 */
public class Demo13 {
    //threshold的含义是域值
    public int movingCount(int threshold, int rows, int cols) {

        //记录是否已经走过
        int[][] flag = new int[rows][cols];

        //表示从0，0开始走
        return helper(0, 0, rows, cols, flag, threshold);

    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j > cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
            return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold) + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold) + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
        //+1是统计格子数
    }

    private int numSum(int i) {

        int sum = 0;

        while (i != 0){
            sum += sum % 10;
            sum = sum / 10;
        }

        return sum;
    }
}
