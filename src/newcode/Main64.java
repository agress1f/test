package newcode;


import java.util.ArrayList;

public class Main64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num.length==0||size==0||size>num.length){
            return ans;
        }

        int Max = Integer.MIN_VALUE;
        int pos = -1;
        //第一个区间内的最大值Max和对应的下标pos
        for (int i=0;i<size;i++){
            if (num[i]>Max){
                Max = num[i];
                pos = i;
            }
        }
        ans.add(Max);
        for (int i=size;i<=num.length-1;i++){
            if (i-size+1<=pos){
                //情况一：最大值还在窗口内
                if (num[i]>Max){
                    Max = num[i];
                    pos = i;
                }
            }else {
                //情况二：最大值不在窗口内
                Max = Integer.MIN_VALUE;
                for (int j=i-size+1;j<=i;j++){
                    if (num[j]>Max){
                        Max = num[j];
                        pos = j;
                    }
                }
            }
            ans.add(Max);
        }
        return ans;
    }
}
