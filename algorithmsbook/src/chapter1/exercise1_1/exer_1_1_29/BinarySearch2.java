package chapter1.exercise1_1.exer_1_1_29;

/**
 * @author ASUS
 * @since 2018-12-04 21:10
 */
public class BinarySearch2 {
    public BinarySearch2(){}
    /**
     * 返回小于key的元素数量
     */
    public static int rank(int key, int arr[]){
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < mid){
                hi = mid - 1;
            }else if(key > mid){
                lo = mid + 1;
            }else{
                while (mid > 0 && arr[mid] == arr[mid - 1]){
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }

    public static int count(int key, int[] arr){
        int cnt = 0;
        int i = rank(key, arr);
        while (i < arr.length - 1 && arr[i] == arr[i + 1]){
            cnt++;
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2};
        int result = rank(2, arr);
        int cnt = count(2, arr);
        System.out.println(result);
        System.out.println(cnt);
    }
}
