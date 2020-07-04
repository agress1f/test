package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/7/2
 * Time: 16:55
 * Description: No Description
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4};
        Select(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Select(int[] arr){
        int pos;
        for (int i=0;i<arr.length-1;i++){
            pos = 0;
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[pos]){
                    pos = j;
                }
            }
            int temp = arr[pos];
            arr[pos] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}
