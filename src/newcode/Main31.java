package newcode;

public class Main31 {
    public int NumberOf1Between1AndN_Solution(int n) {
//        int sum=0;
//        for (int i=0;i<=n;i++){
//                int x=i;
//                while (x!=0){
//                    if (x%10==1){
//                        sum++;
//                    }
//                    x = x/10;
//                }
//            }
//        return sum;
        if (n==0) return 0;
        String str = ""+n;
        int len = str.length();
        if (len==1) return 1;
        int res =(int) Math.pow(10,len-1);//幂级146->100
        int firstNumber = n/res;
        int firstBit = firstNumber==1?(n%res)+1:res;
        int otherBit = (len-1)*firstNumber*res/10;
        return firstBit+otherBit+NumberOf1Between1AndN_Solution(n%res);
    }
}
