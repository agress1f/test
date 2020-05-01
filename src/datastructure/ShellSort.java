package datastructure;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前的："+Arrays.toString(array));
        shellsort2(array);
        System.out.println("排序后的："+Arrays.toString(array));
    }

    private static void shellsort(int[] array) {

        int temp ;
        int count  = 0;
        for (int gap=array.length/2;gap>0;gap/=2){
            for (int i =gap;i<array.length;i++){
            for (int j=i-gap;j>=0;j-=gap){
                if (array[j]>array[j+gap]){
                    temp = array[j+gap];
                    array[j+gap] = array[j];
                    array[j] = temp;
                }
            }
            }
            System.out.println("第"+(++count)+"次希尔排序后的结果："+ Arrays.toString(array));
        }
    }
    private static void shellsort2(int[] array){
        for (int gap=array.length/2;gap>0;gap/=2){
            for (int i=gap;i<array.length;i++){
                int j=i;
                int temp =array[j];
                if (array[j]<array[j-gap]){
                    while (j-gap>=0&&temp<array[j-gap]){
                        array[j] = array[j-gap];
                        j-=gap;
                    }
                    array[j] = temp;
                }
            }
        }
    }

}
