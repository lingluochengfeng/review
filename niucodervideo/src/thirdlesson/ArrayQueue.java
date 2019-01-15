package thirdlesson;

/**
 * 题目一：使用数组结构实现大小固定的队列
 *
 * 思路：使用end和start作为两个索引，end表示入队的位置，start表示出队的位置，size表示数组的大小
 * 利用size将end和start进行解耦。
 * push表示入队，首先判断size是否满，如果满了则抛出异常，否则size++，然后arr[end]=obj，然后调用nextIndex函数更新end的位置
 * poll表示出队，首先判断size是否为0，如果为0则抛出异常，否则size--，然后用一个temp保存start，然后调用nextIndex函数更新start的位置，返回arr[start]
 * peek表示查找当前arr[start]的值是多少
 */
public class ArrayQueue {
    //固定数组
    private Integer[] arr;
    //固定数组的大小
    private Integer size;
    //出队的位置，每次往外拿数的时候，从start开始
    private Integer start;
    //入队的位置，每次数字进入队列的时候，从end开始
    private Integer end;

    private ArrayQueue(int initSize) throws IllegalAccessException {
        if (initSize < 0){
            throw new IllegalAccessException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public Integer peek(){
        if (size == 0){
            return null;
        }
        return arr[start];
    }

    public void push(int obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[end] = obj;
        end = nextIndex(arr.length, end);
    }

    public Integer poll(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int temp = start;
        start = nextIndex(arr.length, start);
        return arr[temp];
    }

    public int nextIndex(int size, int index){
        return index == size - 1 ? 0 : index + 1;
    }
}
