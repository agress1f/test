package newcode;

public class Main67 {
    public int cutRope(int target) {
        int[] dp = new int[target+1];
        if (target==2) return 1;
        if (target==3) return 2;
        dp[1] =1;
        dp[2] =2;
        dp[3] =3;

        for (int k=1;k<=target;k++){
            for (int i=1;i<=k/2;i++){
                dp[k] = Math.max(dp[k],dp[i]*dp[k-i]);
            }
        }
        return dp[target];
    }
}
