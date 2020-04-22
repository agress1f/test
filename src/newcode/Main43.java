package newcode;

public class Main43 {
    public static String LeftRotateString(String str,int n) {
        if (str.length()==0){
            return str;
        }else {
        int x = n%str.length();
        char[] ar = str.toCharArray();
        char[] ar1 = new char[x];
        char[] ar2 = new char[str.length()-x];
        //产生ar1
        for (int j=0;j<x;j++){
            ar1[j] = ar[j];
        }
        //产生ar2
        for (int i=0;i<str.length()-x;i++){
            ar2[i] = ar[x+i];
        }
        //拼接
        char[] ar3 = new char[str.length()];
        for (int i=0;i<ar2.length;i++){
            ar3[i]=ar2[i];
        }
        for (int j=0;j<ar1.length;j++){
            ar3[ar2.length+j] = ar1[j];
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<ar3.length;i++){
            sb.append(ar3[i]);
        }
        String sb1 = sb.toString();
        return sb1;
        }
    }

    public static void main(String[] args) {
        String str = "abcde";
        int n = 3;
        String str2 =LeftRotateString(str,n);
        System.out.printf(str2);
    }
}
