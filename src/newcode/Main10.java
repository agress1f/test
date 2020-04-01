package newcode;

import java.util.Scanner;

public class Main10 {
    public static int RectCover(int target) {
        if (target==1||target==2){
            return target;
        }
        int[] a = new int[target+1];
        a[1] = 1;
        a[2] = 2;
        for (int i=3;i<=target;i++){
            a[i] = a[i-1]+a[i-2];
        }
        return a[target];
    }

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int target = cin.nextInt();
        System.out.println(RectCover(target));
    }
}
