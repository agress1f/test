package newcode;

public class Main30 {
    public int FindGreatestSumOfSubArray(int[] array) {
//        int[] sum =new int[array.length];
//        sum[0]=array[0];
//        for (int i=1;i<array.length;i++){
//            sum[i] = sum[i-1]+array[i];
//        }
//        int Max = sum[0];
//        for (int i=0;i<array.length;i++){
//            for (int j=0;j<=i;j++){
//                if (j==0){
//                    Max = Math.max(Max,sum[i]);
//                }else{
//                    Max = Math.max(Max,sum[i]-sum[j-1]);
//                }
//            }
//        }
//     return Max;
        //有问题，max应该随sum逐步看，有可能全是负数的情况

//        int[] sum=new int[array.length];
//        sum[0]=array[0];
//        for (int i=1;i<array.length;i++){
//            if (sum[i-1]+array[i]<0) {
//                sum[i]=0;
//            }else {
//                sum[i]=sum[i-1]+array[i];
//            }
//        }
//        int Max=0;
//        for (int i=0;i<sum.length;i++){
//            if (Max<sum[i]){
//                Max = sum[i];
//            }
//        }
//        return Max;
        int sum =0;
        int Max = array[0];
        for(int i=0;i<array.length;i++){
            sum+=array[i];
            Max = Math.max(Max,sum);
            if(sum<0){
                sum = 0;
            }
        }
        return Max;
    }
}
