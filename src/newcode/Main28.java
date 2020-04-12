package newcode;

import com.sun.scenario.effect.impl.state.AccessHelper;

import java.util.HashMap;
import java.util.Map;

public class Main28 {
    public static boolean check(int target,int [] array){
        int sum=0;
        for (int x:array){
            if (x ==target){
                sum++;
            }
        }
        return sum>array.length/2;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        int target = array[0];
        int sum = 0;
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int x:array){
//            map.put(x,map.getOrDefault(x,0)+1);
//            if (sum<map.get(x)){
//                sum = map.get(x);
//                target = x;
//            }
//        }
//
//        if (sum>array.length/2){
//            return target;
//        }
//        return 0;
        if (array.length == 0){
            return 0;
        }
        for (int x:array){
            if (x==target){
                sum++;
            }else {
                sum--;
            }
            if (sum==0){
                target =x;
                sum=1;
            }
        }
        if (check(target,array)){
            return target;
        }
        return 0;
    }
}
