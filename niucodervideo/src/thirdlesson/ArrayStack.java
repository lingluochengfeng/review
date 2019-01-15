package thirdlesson;

/**
 * 题目一：使用数组结构实现大小固定的栈
 *
 * 思路：使用一个index来索引数组的位置，
 * 进行push操作时，判断栈满，如果不满则把数放进来，index+1；否则抛出异常
 * 进行pop操作时，判断index是否为0，如果不为0，index-1，然后直接返回arr[index-1]；否则抛出异常
 * 进行peek操作时，判断index是否为0，若不为0，直接返回arr[index-1],否则返回null
 */
public class ArrayStack {

    //固定的数组,即栈
    private Integer[] arr;
    //栈的索引
    private Integer index;

    public ArrayStack(int initSize) throws IllegalAccessException {
        if (initSize < 0)
            throw new IllegalAccessException("th init size is less than 0");
        arr = new Integer[initSize];
        index = 0;
    }

    //如果只拿顶部的数字，不删掉这个数，使用peek方法
    public Integer peek(){
        if (index == 0){
            return null;
        }
        return arr[index - 1];
    }

    public void push(int obj){
        if (index == arr.length){
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        //index位置上放新加入的数，然后index++
        arr[index++] = obj;
    }

    public Integer pop(){
        if (index == 0){
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        //由于push的过程中，index始终指向的是有数的下一个，所以要先--
        return arr[--index];
    }
}
