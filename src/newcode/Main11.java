package newcode;

import java.util.Scanner;

public class Main11 {
    public static int NumberOf1(int n) {
//方法一
        //        int sum = 0;
//        int temp = 1;
//        while (temp!=0){
//            sum = (n & temp)!=0?sum+1:sum;
//            temp = temp << 1;
//        }
//        return sum;
// 方法二
        int sum = 0;
        while (n!=0){
            sum++;
            n= n&(n-1);
        }
        return sum;
    }
   public static void main(String[] args){
       Scanner cin = new Scanner(System.in);
       int n = cin.nextInt();
       System.out.println(NumberOf1(n));
   }

}
