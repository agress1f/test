package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/5/31
 * Time: 15:41
 * Description: No Description
 */
public class test05 {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
    }
    public String replaceSpace(String s) {
        int l  = s.length();
        StringBuffer sb =  new StringBuffer();
        for(int i=0;i<l;i++){
            if(s.charAt(i)==' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
