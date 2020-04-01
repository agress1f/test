package newcode;

import java.util.Scanner;

public class Main8 {
    public static int JumpFloor(int target) {
        if (target==0||target==1){
            return 1;
        }
        int[] f = new int[target+1];
        f[0] = 1;
        f[1] = 1;
        for (int i=2;i<=target;i++){
            f[i] = f[i-1] + f[i-2];

        }
        return f[target];

    }
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int target = cin.nextInt();
        System.out.println(JumpFloor(target));
    }
}
