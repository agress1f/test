package newcode;

import java.util.HashMap;
import java.util.Map;

public class Main37 {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length==0) return 0;
        int l = findFirstPosition(array,k);
        int r = findLastPosition(array,k);
        if (array[l]!=k) return 0;
        return r-l+1;

    }
    private int findFirstPosition(int[] array,int k){
        int l = 0;
        int r = array.length-1;
        while (l<r){
            int mid = (l+r)>>1;
            if (array[mid]==k){
                if (mid-1>=0&&array[mid-1]==k){
                    r = mid - 1;
                }else {
                    return mid;
                }
            }else if (array[mid]>k){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    private int findLastPosition(int[] array,int k){
        int l = 0;
        int r = array.length-1;
        while (l<r){
            int mid = (l+r)>>1;
            if (array[mid]==k){
                if (mid+1< array.length&&array[mid+1]==k){
                    l = mid+1;
                }else {
                    return mid;
                }
            }else if (array[mid]>k){
                r = mid-1;
            }else {
                l=mid+1;
            }
        }
        return l;
    }

    //        int sum=0;
//        for (int i=0;i<array.length;i++){
//              if (array[i]==k){
//                  sum++;
//              }
//          }
//        return sum;

}
