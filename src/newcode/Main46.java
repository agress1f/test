package newcode;

public class Main46 {
    public int LastRemaining_Solution(int n, int m) {
//        if (n==0||m==0) return -1;
//        boolean[] vis = new boolean[n];
//        int sum = 0;
//        int res = 0;
//        int index = 0;
//        while (sum<n-1){
//            res=0;
//            while (vis[index]){
//                index = (index+1)%n;
//            }
//            while (res<m){
//                if (!vis[index]){
//                    res++;
//                }
//                index = (index+1)%n;
//            }
//            vis[(index+n-1)%n]=true;
//            sum++;
//        }
//
//        while (vis[index]){
//            index = (index+1)%n;
//        }
//        return index;
        if (n==0||m==0){
            return -1;
        }
        int ans = 0;
        for (int i=2;i<=n;i++){
            ans = (ans+m)%i;
        }
        return ans;
    }
}
