package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/7/2
 * Time: 16:29
 * Description: No Description
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4};
        Bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Bubble(int[] arr){
        int change;
        for (int i=0;i<arr.length-1;i++){
            change = 0;
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    change = 1;
                }
            }
            if (change == 0){
                break;
            }
        }
    }
}
