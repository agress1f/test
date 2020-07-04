package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/7/2
 * Time: 20:13
 * Description: No Description
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4};
        Shell(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void Shell(int[] arr){
        for (int step=arr.length/2;step>0;step/=2){

            for (int i=step;i<arr.length;i++){
                int j = i;
                int temp = arr[j];

                while (j-step>=0 && arr[j-step]>temp){
                    arr[j] = arr[j-step];
                    j = j - step;
                }
                arr[j] = temp;
            }
        }
    }
}
