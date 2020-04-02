package newcode;

import java.util.Arrays;
import java.util.Scanner;

public class Main13 {
    public static int[] reOrderArray(int [] array) {
//        int sumJ = 0;
//        int sumO = 0;
//        int l = array.length;
//        for (int i =0;i<l;i++){
//            if (isJi(array[i])){
//                sumJ ++;
//            }else {
//                sumO++;
//            }
//        }
//        int[] Ji = new int[sumJ];
//        int[] O = new int[sumO];
//        int m = 0;
//        int n = 0;
//        for (int i = 0;i<l;i++){
//            if (isJi(array[i])){
//                Ji[m] = array[i];
//                m++;
//            }else {
//                O[n]  = array[i];
//                n++;
//            }
//        }
//        int[] res = arrayJoin(Ji,O);
//        array = Arrays.copyOf(res,l);
//        return array;
        int len = array.length;
        for (int i =0;i<len;i++){
            if (array[i]%2!=0){
                for (int j=i-1;j>=0;j--){
                    if (array[j]%2==0){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }else {
                        break;
                    }
                }
            }
        }
        return array;
    }

//    //判断奇偶
//    public static boolean isJi(int n){
//        if (n%2==1){
//            return true;
//        }else {
//            return false;
//        }
//    }
//    public static int[] arrayJoin(int[] a,int[] b){
//        int[] arr=new int[a.length+b.length];//开辟新数组长度为两数组之和
//        for(int i=0;i<a.length;i++){//拷贝a数组到目标数组arr
//            arr[i]=a[i];
//        }
//        for(int j=0;j<b.length;j++){//拷贝b数组到目标数组arr
//            arr[a.length+j]=b[j];
//        }
////        for(int i=0;i<arr.length;i++){//输出目标数组
////            System.out.print(arr[i]+" ");
////        }
//        return  arr;
//    }

    public static void main(String[] args){
        int n;
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();

        int array[] = new int[n];
        for(int i=0;i<n;i++){
            array[i]=cin.nextInt();
        }
        System.out.println(Arrays.toString(reOrderArray(array)));


    }

}
