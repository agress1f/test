package leetcode;

import java.util.Scanner;

public class exam01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrays = new int[n];
        for (int i=0;i<n;i++){
            arrays[i] = sc.nextInt();
        }
        System.out.println(medthod(n,arrays));
    }
    public static int medthod(int N,int[] arrays){
        if (N==0){
            return 0;
        }
        if (N==1){
            return arrays[0];
        }

        int first = arrays[0];
        int second = Math.max(arrays[0],arrays[1]);
        for (int i=2;i<N;i++){
            int temp = second;
            second = Math.max(first+arrays[i],second);
            first = temp;
        }
        return second;
    }
}
