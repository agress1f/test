package newcode;

public class Main49 {
    public int StrToInt(String str) {
        int len = str.length();
        int index = 0;
        //删除空格返回有字符的下标index
        while (index<len){
            if (str.charAt(index)==' '){
                index++;
            }else {
                break;
            }
        }
        int flag = 0;
        long ans =0;
        boolean flag1 = false;
        while (index<len){
            if (!flag1&&str.charAt(index)=='-'||str.charAt(index)=='+'){
                if (flag!=0){
                    return 0;//第二个非法字符
                }
                flag = str.charAt(index) =='-'?-1:1;
            }else if (str.charAt(index)>='0'&&str.charAt(index)<='9'){
                flag1 =true;
                ans = ans*10+str.charAt(index)-'0';
                //对ans是否溢出int类型做下判断
                if (judge(ans,flag)){
                    return 0;
                }
            }else {
                return 0;//既不是数字，也不是正负号，其他字符，返回零
            }
            index++;
        }
        return flag==-1?(int)ans*(-1):(int)ans;
    }

    private boolean judge(long ans, int flag) {
        if (flag==-1){
            if (ans*(-1)<Integer.MIN_VALUE){
                return true;
            }
            return false;
        }else {
            if (ans>Integer.MAX_VALUE){
                return true;
            }
            return false;
        }
    }
}
