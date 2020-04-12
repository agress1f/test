package newcode;

import java.util.ArrayList;

public class Main29 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
       int l =input.length;

       for (int i=0;i<l;i++){
           for (int j=0;j<l-i-1;j++){
               if (input[j+1]<input[j]){
                   int temp = input[j+1];
                   input[j+1] = input[j];
                   input[j] = temp;
               }
           }
       }
       ArrayList<Integer> res = new ArrayList<>();
       if (k>l){
           k=l;
       }
       for (int i=0;i<k;i++){
           res.add(input[i]);
       }
       return res;
    }

    public static void main(String[] args) {
        int[] input= {1,2,3,4,5,6,7,8};
        int k = 4;
        System.out.println(GetLeastNumbers_Solution(input,k));
    }

}
