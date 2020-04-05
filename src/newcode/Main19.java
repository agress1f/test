package newcode;

import java.util.ArrayList;

public class Main19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer>  ans = new ArrayList<>();
        int flag = 1;//1->right 2->down 3->left 4->up
        int x= 0;
        int y= 0;
        boolean [][] way =new boolean[matrix.length][matrix[0].length];
        while (ans.size()<matrix.length*matrix[0].length){
            if (x<0||x>=matrix.length||y<0||y>=matrix[0].length||way[x][y]){
                if (flag == 1){
                    flag =2;
                    y--;
                    x++;
                }else if (flag ==2){
                    flag = 3;
                    y--;
                    x--;
                }else if (flag ==3){
                    flag =4;
                    y++;
                    x--;
                }else{
                    flag =1;
                    x++;
                    y++;
                }
            }else {
                way[x][y] = true;
                ans.add(matrix[x][y]);
                if (flag==1){
                    y++;
                }else if (flag == 2){
                    way[x][y] = true;
                    x++;
                }else if (flag ==3){
                    way[x][y] = true;
                    y--;
                }else {
                    way[x][y] = true;
                    x--;
                }

            }
        }
        return ans;
    }
}
