package chapter1.exercise1_1.exer_1_1_28;


public class DelDuplBinarySearch {
    //统计重复数字的数量
    public static int count(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i + 1]){
                count++;
            }
        }
        return count;
    }

    public static int[] remove(int[] arr, int count){
        int s = 0;
        int[] b = new int[arr.length - count];
        b[0] = arr[0];
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i + 1]){
                s++;
            }else{
                b[i - s + 1] = arr[i + 1];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {2,2,2,3,4,5,6};
        int count = count(a);
        System.out.println("count的值是：" + count);
        int[] result = remove(a,count);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
