package leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class test01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] str = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length;i++){
            char c=str[i];
            if(Character.isUpperCase(c)){
                str[i] = Character.toLowerCase(c);
            }
        }

        for(int i=0;i<str.length;i++){
            char c=str[i];
            if(i==0||str[i-1]==' '){
                str[i] = Character.toUpperCase(c);
            }
        }

        for(int i=0;i<str.length;i++){
            list.add(str[i]);
        }


        int index = 0;
        while(index<list.size()){
            if(list.get(index)=='a'||list.get(index)=='e'||list.get(index)=='i'||list.get(index)=='o'||list.get(index)=='u'||list.get(index)=='A'||list.get(index)=='E'||list.get(index)=='I'||list.get(index)=='O'||list.get(index)=='U'){
                sb.append(list.get(index));
                index = index + 2;
            }else{
                sb.append(list.get(index++));
            }
        }


        System.out.println(sb.toString());

    }
}