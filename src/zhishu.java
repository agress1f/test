import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class zhishu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            int j;
            for (j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) break;
            }

            if (j > Math.sqrt(i))
                list.add(i);
        }
        System.out.println(list);

    }
}
