package newcode;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main27 {
    private static String change(char[] a){
        StringBuilder res = new StringBuilder();
        for (char value : a){
            res.append(value);
        }
        return res.toString();
    }

    private static void solve(ArrayList<String> ans,char[] a,int index,int length){
        if (index==length-1){
            String res = change(a);
            ans.add(res);
        }else {
            for (int i =index;i<length;i++){
                char temp = a[i];
                a[i] = a[index];
                a[index] = temp;
                solve(ans, a, index+1, length);
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }

    }
    public static ArrayList<String> Permutation(String str) {
        char[] a = str.toCharArray();
        ArrayList<String> ans = new ArrayList<>();
        solve(ans,a,0,str.length());
        ans = new ArrayList<String>(new HashSet<String>(ans));
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.next();
        System.out.println(Permutation(str));
    }
}
