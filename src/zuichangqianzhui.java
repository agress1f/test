
public class zuichangqianzhui {
    public static void main(String[] args) {
        String str1 = "a2abccc";
        String str2 = "bddda2a";
        int result = longest(str1,str2);
        System.out.println(result);
    }
    public static int longest(String str1,String str2){
        String str3 = str2+str2;
        char[] s1 = str1.toCharArray();
        char[] s3 = str3.toCharArray();

        int s1Len = s1.length;
        int s3Len = s3.length;
        int i = 0;
        int j = 0;
        int count = 0;
        int[] res =new int[s3Len];
        int index=0;
        while (i<s1Len&&j<s3Len){
            if (s1[i]==s3[j]){
                i++;
                j++;
                count++;
            }else {
                res[index++] = count;
                j++;
                count = 0;
            }
        }
        int max = 0;
        for (int k=0;k<s3Len;k++){
            if (res[k]>=max){
                max = res[k];
            }
        }
        return max;
    }
}
