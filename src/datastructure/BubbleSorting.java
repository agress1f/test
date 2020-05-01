package datastructure;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] array = new int[]{3,9,-1,10,20};
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(Arrays.toString(array));
    }
}
