package newcode;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/6/17
 * Time: 10:11
 * Description: No Description
 */
public class examtest {
public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        char[] str = s.toCharArray();
//        Set set = new LinkedHashSet();
//        for(int i=0;i<str.length;i++){
//            set.add(str[i]);
//        }
//        System.out.println(set.toString());
//    }
    String a = "AAABBccDFDACggghh";
    int[] table = new int[150];
    StringBuffer sb = new StringBuffer();
    char[] chars = a.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        int flag = (int) chars[i];   //找到
        table[flag] = ++table[flag];
        if (table[flag] == 1) {
            sb.append((char) flag);
        }
    }
    System.out.println(sb.toString());
}
}
