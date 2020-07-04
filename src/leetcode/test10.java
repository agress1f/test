package leetcode;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/5/31
 * Time: 18:59
 * Description: No Description
 */
public class test10 {
    public static int fib(int n) {
        int res = solve(n)%1000000007;
        return res;
    }
    private static   int solve(int n){
        if(n==1||n==0){
            return n;
        }


        return solve(n-1) + solve(n-2);
    }
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        System.out.println(fib(n));

    }

    public static void solve(String s,int maxLine){
        int len = s.length();
        if(len<=maxLine){
            System.out.println("{"+s+"}");
        }
        int index = 0;
        while (index!=len){
            if (s.charAt(index)==' '){
                index++;
            }
            if(len-maxLine-index>0) {
                String temp = s.substring(index, index + maxLine - 1);

                if (s.charAt(index + maxLine) == ' ') {
                    System.out.println("{" + s.substring(index, index + maxLine) + "}");
                    index += maxLine;
                } else if (s.charAt(index + maxLine - 1) == ' ') {
                    System.out.println("{" + temp + "}");
                    index += maxLine - 1;
                } else {
                    System.out.println("{" + temp + "-}");
                    index += maxLine - 1;
                }
            }else {
                System.out.println("{"+s.substring(index,len)+"}");
                return;
            }

        }
    }
}
