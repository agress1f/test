package newcode;

public class Main44 {
    public String ReverseSentence(String str) {
        String flipStr =new StringBuilder(str).reverse().toString();
        StringBuilder res = new StringBuilder();//遍历单词
        StringBuilder ans = new StringBuilder();//保存结果
        for (int i=0;i<flipStr.length();i++){
            if (flipStr.charAt(i)==' '){
                ans.append(res.reverse().toString()).append(" ");
                res = new StringBuilder();
            }else {
                res.append(flipStr.charAt(i));
            }
        }
        ans.append(res.reverse().toString());
        return ans.toString();
    }
}
