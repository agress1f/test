package newcode;

public class Main52 {
    public boolean match(char[] str, char[] pattern) {
        return solve(str,pattern,0,0);
    }

    private boolean solve(char[] str, char[] pattern, int index1, int index2) {
        //递归终止条件一
        if (index1==str.length && (index2==pattern.length||(index2+1==pattern.length-1)&&pattern[index2+1]=='*')){
            return true;
        }
        //递归终止条件二
        if (index1==str.length||pattern.length==index2){
            if (index1==str.length){
                return change(pattern,index2);
            }else {
                return false;
            }
        }

        if (index2+1<pattern.length&&pattern[index2+1]=='*'){
            if (judge(str[index1],pattern[index2])){
                return solve(str,pattern,index1,index2+2)||solve(str,pattern,index1+1,index2);
            }else {
                return solve(str,pattern,index1,index2+2);
            }
        }
        if (judge(str[index1],pattern[index2])){
            return solve(str,pattern,index1+1,index2+1);
        }
        return false;
    }

    private boolean judge(char s1, char s2) {
        if (s1==s2||s2=='.'){
            return true;
        }
        return false;
    }

    private boolean change(char[] pattern, int index2) {
        while (index2<pattern.length){
            if (index2+1<pattern.length&&pattern[index2+1]=='*'){
                index2 += 2;
            }else {
                return false;
            }

        }
        return true;
    }
}
