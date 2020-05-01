package datastructure;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {101,34,119,1};
        System.out.println("前："+ Arrays.toString(array));
        insertsort(array);
        System.out.println("后："+Arrays.toString(array));
    }

    private static void insertsort(int[] array) {
        for (int i=1;i<array.length;i++){
            int insertVal = array[i];
            int insertindex = i-1;
            while (insertindex>=0&&insertVal<array[insertindex]){
                array[insertindex+1] = array[insertindex];
                insertindex--;
            }
            array[insertindex+1] = insertVal;
        }
    }
}
