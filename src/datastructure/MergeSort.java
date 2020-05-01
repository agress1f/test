package datastructure;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        divide(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void divide(int l,int r,int[] arr){
        if (l!=r){
            int mid=(l+r)>>1;
            divide(l,mid,arr);
            divide(mid+1,r,arr);
            merge(l,r,mid,arr);
        }
    }

    public static void merge(int l, int r, int mid, int[] arr) {
        int i = l;
        int j = mid+1;
        int[] temp = new int[arr.length];
        int index = 0;
        while (i<=mid&&j<=r){
            if (arr[i]>arr[j]){
                temp[index++] = arr[j++];
            }else {
                temp[index++] = arr[i++];
            }
        }
        while (i<=mid){
            temp[index++] = arr[i++];
        }
        while (j<=r){
            temp[index++]  =arr[j++];
        }
        index = 0;
        while (l<=r){
            arr[l++]=temp[index++];
        }
    }
}
