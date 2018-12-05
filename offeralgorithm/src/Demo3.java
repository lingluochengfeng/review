/**
 * 找到数组中重复的数字
 * 解法一：把输入的数组排序，从排序的数组中找到重复的数字
 * 解法二：利用哈希表解决该问题
 *      1.从头到尾按顺序扫描数组中的每个数字，
 *          每扫描到一个数字时，可以用O(1)的时间来判断哈希表中是否包含该数字
 *      2.如果哈希表中有该数字，就找到一个重复数字；如果没有该数字，则把它放入哈希表
 * @author ASUS
 * @since 2018-10-06 11:54
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] array = {4,3,1,0,2,5,3};
        int result = duplicateNumber(array);
        System.out.println("重复的数字是:" + result);
    }

    private static int duplicateNumber(int[] array){
        if (array == null || array.length <= 0){
            return -1;
        }

        for (int i = 0; i < array.length; i++){
            if (array[i] < 0 || array[i] >= array.length){
                return -1;
            }
        }

        for (int i = 0; i < array.length; i++){
            if (i != array[i] && array[i] == array[array[i]]){
                return array[i];
            }
            while (i != array[i]){
                int temp = array[i];
                array[i] = i;
                i = temp;

            }
        }
        return -1;
    }
}
