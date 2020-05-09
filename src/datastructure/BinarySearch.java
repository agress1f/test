package datastructure;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8,10,10,10,89,1000,1234};
        //int res = binarySearch(arr,0,arr.length-1,88);
        List<Integer> res = binarySearch2(arr,0,arr.length-1,10);
        System.out.print(res);
    }
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left>right){
            return -1;
        }
        int mid = (left+right)>>1;
        int midVal = arr[mid];

        if (findVal>midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }

    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if (left>right){
            return new ArrayList<>();
        }
        int mid = (left+right)>>1;
        int midVal = arr[mid];

        if (findVal>midVal){
            return binarySearch2(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return binarySearch2(arr,left,mid-1,findVal);
        }else{
            ArrayList<Integer> resIndex = new ArrayList<>();
            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                resIndex.add(temp);
                temp-=1;
            }
            resIndex.add(mid);
             temp = mid +1;
             while (true){
                 if (temp>arr.length-1||arr[temp]!=findVal){
                     break;
                 }
                 resIndex.add(temp);
                 temp+=1;
             }
             return resIndex;
        }

    }
}
