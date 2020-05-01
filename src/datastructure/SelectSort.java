package datastructure;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{101,34,119,1};
        System.out.println("排序前:"+ Arrays.toString(array));
        selectsort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }

    private static void selectsort(int[] array) {

        for (int i=0;i<array.length-1;i++){
            int minindex = i;
            int min = array[i];
            for (int j=i+1;j<array.length;j++){
                if (min>array[j]){
                    min = array[j];
                    minindex = j;
                }

            }
            if (minindex!=i){
                array[minindex] = array[i];
                array[i] = min;
            }
        }

    }
}
