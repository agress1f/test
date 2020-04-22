package newcode;

public class Main47 {
    public int Sum_Solution(int n) {
//        return ((int)Math.pow(n,2)+n)/2;
        int sum = n;
        boolean flag = (n>0)&&(sum+=Sum_Solution(n-1))>0;
        return sum;
    }
}
