package newcode;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str1.length();i++){
            if (Character.isDigit(str1.charAt(i))){
                sb.append(str1.charAt(i));
            }
        }
        String str2 = sb.toString();
        int[] a = new int[str2.length()];
        for (int i=0;i<str2.length();i++){
            a[i] = Integer.parseInt(str2.substring(i,i+1));
        }


        for (int i =0;i<a.length-1;i++){
            for (int j=a.length-1;j>0;j--){
                if (a[j]<a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }

        String str3="";
        for (int i=0;i<a.length;i++){
            str3+=a[i];
        }
        System.out.println(str3);
    }
}
