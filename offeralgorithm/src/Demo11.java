import com.sun.org.apache.regexp.internal.RE;

import java.util.Vector;

/**
 * 旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个排序，输出旋转数组的最小元素。
 * 例如，数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
 */

public class Demo11 {
    //解法一
    int minNumberInRotateArray1(int[] array) throws Exception {
        if (array == null || array.length == 0)
            return 0;

        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;

        while (array[index1] >= array[index2]){
            if (index2  - index1 == 1){
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;
            if (array[indexMid] >= array[index1])
                index1 = indexMid;
            else if (array[indexMid] <= array[index2])
                index2 = indexMid;
        }
        return array[indexMid];
    }

    //更加完善的步骤
    int minNumberInRotateArray2(int[] array) throws Exception {
        if (array == null || array.length == 0)
            return 0;

        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;

        while (array[index1] >= array[index2]){
            if (index2  - index1 == 1){
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;

            //如果下标为index1、index2和indexMid指向的三个数字相等
            //则只能顺序查找
            if (array[index1] == array[index2]
                    && array[indexMid] == array[index1]){
                return MinInOrder(array,index1,index2);
            }
            if (array[indexMid] >= array[index1])
                index1 = indexMid;
            else if (array[indexMid] <= array[index2])
                index2 = indexMid;
        }
        return array[indexMid];
    }

    private int MinInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; ++i){
            if (result > array[i])
                result = array[i];
        }
        return result;
    }
}
