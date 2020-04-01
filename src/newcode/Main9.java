package newcode;

import java.util.Scanner;

public class Main9 {
    public static int JumpFloorII(int target) {
        //排除0和1两种情况
        if (target==1||target==0){
            return 1;
        }
        if (target==2){
            return 2;
        }
        int temp = 0;
        int i = 0 ;
        while (i<target){
            temp =temp  + JumpFloorII(i);
            i++;
        }

        return temp;
    }

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int target = cin.nextInt();
        System.out.println(JumpFloorII(target));
    }
}
