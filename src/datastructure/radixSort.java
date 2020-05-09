package datastructure;

import java.util.Arrays;

public class radixSort {
    public static void main(String[] args) {
        int arr[] = {53,3,542,748,14,214};
        radixSort(arr);
    }
    public static void radixSort(int arr[]){
        int[][] bucket = new int[10][arr.length];
        int[] bucketEleCounts = new int[10];
        int max = arr[0];
        for(int i=0;i<arr.length;i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();

        for (int i=0,n=1;i<maxLength;i++,n=n*10){
            //第一轮
            for (int j = 0; j < arr.length; j++) {
                int digitEle = arr[j] / n % 10;
                bucket[digitEle][bucketEleCounts[digitEle]] = arr[j];
                bucketEleCounts[digitEle]++;
            }
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                if (bucketEleCounts[k] != 0) {
                    for (int l = 0; l < bucketEleCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketEleCounts[k] = 0;
            }
            System.out.println("第"+(i+1)+"轮：" + Arrays.toString(arr));
        }
    }
//        //第二轮
//        /*
//        for (int j=0;j<arr.length;j++){
//            int digitEle = arr[j]/10%10;
//            bucket[digitEle][bucketEleCounts[digitEle]] = arr[j];
//            bucketEleCounts[digitEle]++;
//        }
//         index = 0;
//        for (int k=0;k<bucket.length;k++){
//            if (bucketEleCounts[k]!=0){
//                for (int l=0;l<bucketEleCounts[k];l++){
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            bucketEleCounts[k]=0;
//        }
//        System.out.println("第二轮："+ Arrays.toString(arr));
//
//        //第三轮
//        for (int j=0;j<arr.length;j++){
//            int digitEle = arr[j]/100%10;
//            bucket[digitEle][bucketEleCounts[digitEle]] = arr[j];
//            bucketEleCounts[digitEle]++;
//        }
//        index = 0;
//        for (int k=0;k<bucket.length;k++){
//            if (bucketEleCounts[k]!=0){
//                for (int l=0;l<bucketEleCounts[k];l++){
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            bucketEleCounts[k]=0;
//        }
//        System.out.println("第三轮："+ Arrays.toString(arr));
//    }*/
   }
