package leetcode;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/6/17
 * Time: 19:59
 * Description: No Description
 */
public class test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        solve(s,n);

    }

    public static void solve(String s,int maxLine){
        int len = s.length();

        int index = 0;
        while (true){
            if (s.charAt(index)==' '){
                index++;
            }
            if(len - maxLine - index>0) {
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

    public static void solve1(String s,int maxLine){
        int len = s.length();

        int index = 0;
        while (true){
            if (s.charAt(index)==' '){
                index++;
            }
            if(len - maxLine - index>0) {
                String temp = s.substring(index, index + maxLine - 1).trim();

                if (s.charAt(index + maxLine) == ' ') {
                    System.out.println("{" + s.substring(index, index + maxLine).trim() + "}");
                    index += maxLine;
                } else if (s.charAt(index + maxLine - 1) == ' ') {
                    System.out.println("{" + temp + "}");
                    index += maxLine - 1;
                } else {
                    System.out.println("{" + temp + "-}");
                    index += maxLine - 1;
                }
            }else {
                System.out.println("{"+s.substring(index,len).trim()+"}");
                return;
            }

        }
    }
}


