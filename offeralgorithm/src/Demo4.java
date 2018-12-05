/**
 * 二维数组中的查找
 * @author ASUS
 * @since 2018-09-30 17:05
 */
public class Demo4 {
    public static boolean Find(int target, int[][] array){
        int rows = array.length;
        int columns = array[0].length;

        int row = 0;

        while (row < rows && columns > 0){
            if (target > array[row][columns - 1]){
                row++;
            }else if(target < array[row][columns - 1]){
                columns--;
            }else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        boolean flag = Find(22,arr);
        System.out.println(flag);
    }
}
