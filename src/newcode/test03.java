package newcode;

import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[m];
        for(int i=0;i<a.length;i++){
            a[i] = in.nextInt();
        }
        int sum = 0;
        for (int i=0;i<a.length;i++){
            sum +=a[i];
        }
        int left = a[0];
        int right = sum;
        int mid;
        while (left<right){
            mid = (right+left)/2;
            int cnt = 1;
            int subSum = 0;
            for (int i=0;i<m;i++){
                if (subSum+a[i]>mid){
                    subSum = a[i];
                    cnt++;
                }else {
                    subSum+=a[i];
                }
            }
            if (cnt>m){
                left =mid+1;
            }else {
                right =mid;
            }
        }
    }
}
