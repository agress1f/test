package datastructure;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1,4,3};//重量
        int[] val = {1500,3000,2000};//物品价值
        int m = 4;//背包容量
        int n = val.length;//物品个数

        int[][] v = new int[n+1][m+1];

        int[][] path = new int[n+1][m+1];


        for (int i=0;i<v.length;i++){
            v[i][0] = 0;
        }
        for (int i=0;i<v.length;i++){
            v[0][1] = 0;
        }
        //根据公式动态规划处理
        for (int i=1;i<v.length;i++){
            //不处理第一行全零不处理
            for (int j=1;j<v[0].length;j++){
                //不处理第一列
                //套用公式
                if (w[i-1]>j){//程序从1开始，因此原来公式中的w[i]修改成w[i-1]
                    v[i][j] = v[i-1][j];
                }else {//下标调整

                    //v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录商品存放到背包的情况，不能直接使用上面的公式需要使用ifelse
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }




        //输出
        for (int i= 0;i<v.length;i++){
            for (int j=0;j<v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("==========================");
        //输出最后放入哪些商品
//        for (int i=0;i<path.length;i++){
//            for (int j=0;j<path[i].length;j++){
//                if (path[i][j]==1){
//                System.out.printf("第%d个商品放入到背包\n",i);
//                }
//            }
//        }
        int i=path.length-1;
        int j=path[0].length-1;
        while (i>0 &&j>0){
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入到背包\n",i);
                j-=w[i-1];
            }
            i--;
        }
    }
}
