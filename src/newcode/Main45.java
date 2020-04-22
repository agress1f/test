package newcode;


import java.util.Arrays;

public class Main45 {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length==0){
            return false;
        }
        int sum = 0;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]==0){
                sum++;
            }
        }
        Arrays.sort(numbers);
        for (int i=sum+1;i<numbers.length;i++){
            sum -= numbers[i] - numbers[i-1] - 1;
            if (sum<0||numbers[i]==numbers[i-1]){
                return false;
            }
        }
        return true;
    }
}
