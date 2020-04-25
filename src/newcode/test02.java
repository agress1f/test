package newcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strs = line.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<strs.length;i++){
            if (strs[i].equals("5a")){
                list.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("5a").append(" ");
        for (int i=0;i<list.size();i+=2){
            int start = list.get(i)+1;
            int end = list.get(i+1)-1;
            int length = end -start;
            for (int j =start;j<end;j++){
                if (strs[j].equals("5b")){
                    if (j+1<end&&(strs[j+1].equals("ba")||strs[j+1].equals("bb"))){
                        length--;
                    }
                }
            }
            if (length==Integer.parseInt(strs[end],16)){
                for (int k=start;k<=end;k++ ){
                    sb.append(strs[k]).append(" ");
                }
                sb.append("5a").append(" ");
            }
        }
        String ans = sb.append("5a").toString();
        System.out.println(ans);

    }
}
