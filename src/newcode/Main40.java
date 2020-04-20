package newcode;

import java.util.HashMap;
import java.util.Map;

public class Main40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
//        for (int i=0;i<array.length;i++){
//            map.put(array[i],map.getOrDefault(array[i],0)+1);
//        }
//        int flag=1;
//        for (int i=0;i<array.length;i++){
//            if (map.get(array[i])==1){
//                if (flag==1){
//                    num1[0] = array[i];
//                    flag = 2;
//                }
//                if (flag==2){
//                    num2[0]=array[i];
//                }
//            }
//        }
        if (array.length!=0){
            int ans = 0;
            for (int x:array){
                ans ^=x;
            }
            int lastNumber = find(ans);
            num1[0]=0;
            num2[0]=0;
            for (int x:array){
                if (judge(x,lastNumber)==0){
                    num1[0]^=x;
                }else {
                    num2[0]^=x;
                }
            }
        }
    }

    private int judge(int x, int lastNumber) {
        x>>=(lastNumber-1);
        return x&1;
    }

    private int find(int ans) {
        int sum = 1;
        int res = 1;
        while ((ans&res)==0){
            sum++;
            res<<=1;
        }
        return sum;
    }
}
