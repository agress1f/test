package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/7/2
 * Time: 17:32
 * Description: No Description
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4};
        Insert(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Insert(int[] arr){
        int temp;
        for (int i=1;i<arr.length;i++){
            temp = arr[i];
            while(i>=1 && arr[i-1]>temp){
                arr[i] = arr[i-1];
                i--;
            }
            arr[i] = temp;
        }
    }
}
