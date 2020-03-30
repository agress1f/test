package newcode;

import java.util.Scanner;

public class Main {
//    public static boolean Find(int target, int [][] array) {
//        for(int i=0;i<array.length;i++){
//            for (int j=0;j<array[0].length;j++){
//                if (array[i][j] == target)
//                    return true;
//            }
//        }
//        return false;
    //右上角
//    public static boolean Find(int target,int [][] array){
//        int i = 0;//start
//        int j =array[0].length-1;
//        while (i>=0&&i<=array.length&&j>=0&&j<=array[0].length){
//            if (array[i][j]==target)
//                return true;
//            else if(array[i][j]>target)
//                j--;
//            else
//                i++;
//
//        }
//        return false;
//    }

    //左下角
public static boolean Find(int target,int [][] array){
    int i = array.length - 1;//start
    int j = 0;
    while (i>=0&&i<array.length&&j>=0&&j<array[0].length){
        if (array[i][j]==target)
            return true;
        else if(array[i][j]>target)
            i--;
        else
            j++;

    }
    return false;
}

    public static void main(String[] args){
        int n,m;
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        int array[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j]=cin.nextInt();
            }
        }
        //为了增加实验次数
        for(int i=0;i<n*m;i++) {
            int target = cin.nextInt();
            System.out.print(Find(target, array));
        }
    }

}
