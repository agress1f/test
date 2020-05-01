package datastructure;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int mid = arr[(left+right)/2];
        int temp = 0;
        while (l<r){
            while (arr[l]<mid){
                l+=1;
            }
            while (arr[r]>mid){
                r-=1;
            }
            if (l>=r){
                break;
            }
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            if (arr[l]==mid){
                r-=1;
            }
            if (arr[r]==mid){
                l+=1;
            }
            if (l==r){
                l+=1;
                r-=1;
            }
            if (left<r){
                quickSort(arr,left,r);
            }
            if (right>l){
                quickSort(arr,l,right);
            }
        }
    }

}
