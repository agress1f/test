package newcode;

import java.util.Scanner;

public class Main12 {
    public static double Power(double base, int exponent) {
//        double res = 1;
//        if (exponent<0)return Math.pow(base,exponent);
//        for(int i=1;i<=exponent;i++){
//            res = res * base;
//        }
//        return res;

        //分正负来讨论
        double res = 1.0;
        if (exponent>=0){
            for (int i = 1;i<=exponent;i++){
                res = res*base;
            }
        } else {
            for (int i =1;i<= -exponent;i++){
                res = res*base;
            }
            res = 1 / res;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//exponent
        double m = cin.nextDouble();//base
        System.out.println(Power(m,n));
    }
}
