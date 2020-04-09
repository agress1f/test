package newcode;

import java.util.ArrayList;

public class Main23 {
    private boolean solve(ArrayList<Integer> list){
        if (list.size()==0||list.size()==1) return true;
        ArrayList<Integer> minList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        int endNumber = list.get(list.size()-1);
        int minIndex = -1;
        int maxIndex = -1;
        for (int i=0;i<list.size();i++){
            if (list.get(i)>endNumber){
                if (maxIndex ==-1){
                    maxIndex = i;
                }
                maxList.add(list.get(i));
            }else if (list.get(i)<endNumber){
                if (minIndex == -1){
                    minIndex = i;
                }
                minList.add(list.get(i));
            }
        }
        if (minIndex!=-1&&maxIndex!=-1){
            if (minIndex>maxIndex){
                return false;
            }
            for (int i =maxIndex;i<list.size();i++){
                if (list.get(i)<endNumber){
                    return false;
                }
            }
        }
        return solve(minList)&&solve(maxList);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<sequence.length;i++){
            list.add(sequence[i]);
        }
        return solve(list);
    }
}
