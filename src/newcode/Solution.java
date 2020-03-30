package newcode;

import java.util.Scanner;

public class Solution {
    public static String replaceSpace(StringBuffer str) {
        int l = str.length();
        StringBuffer sb = new StringBuffer();
        String res ="%20";
        for (int i =0;i<l;i++){
            if (str.charAt(i)==' ') {
                sb.append(res);
            }else {
                sb.append(str.charAt(i));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args){
        StringBuffer sb1 = new StringBuffer();
        Scanner cin = new Scanner(System.in);
        sb1.append(cin.nextLine());
        System.out.println(replaceSpace(sb1));

    }
}
