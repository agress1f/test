package newcode;

public class Main50 {
    public static boolean duplicate(int numbers[],int length,int [] duplication) {

            int ans =-1;
            for (int i=0;i<length;i++){
                if (numbers[i] == i){
                    continue;
                }
                if (numbers[numbers[i]] == numbers[i]){
                    ans = numbers[i];
                    break;
                }
                int temp = numbers[i];
                numbers[i]=numbers[numbers[i]];
                numbers[temp] = temp;

            }
            duplication[0]=ans;
            return duplication[0]!=-1;
    }

    public static void main(String[] args) {
        int a[]  =new int[]{2,1,3,1,4};
        int length = 5;
        int duplication[] =new int[2];
        System.out.println(duplicate(a,length,duplication));

    }

}
