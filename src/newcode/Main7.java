package newcode;

import java.util.Scanner;

public class Main7 {
    public static int Fibonacci(int n){
//        if (n==0||n==1){
//            return n;
//        }
//        int[] f = new int[n+1];
//        f[0] = 0;
//        f[1] = 1;
//        for (int i=2;i<=n;i++){
//            f[i] = f[i-1]+f[i-2];
//        }
//        return f[n];
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        System.out.println(Fibonacci(n));


    }
}
