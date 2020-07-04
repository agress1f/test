package newcode;

public class Main6 {
//    public int minNumberInRotateArray(int [] array) {
//        for(int i=1;i<array.length;i++){
//            if(array[i-1]>array[i])
//                return array[i];
//        }
//        return array[0];

    //二分法
    public static int minNumberInRotateArray(int [] array){
        int l = 0;
        int r = array.length-1;

        while (array[l]<array[r-1]){
            int mid = (l+r)>>1;
            if (array[mid]>=array[l]){
                l=mid;
            }else if (array[mid]<=array[r]){
                r=mid;
            }
        }
        return array[r];
    }

    public static void main(String arg[]){
        int[] array = {4,5,6,7,8,1,2};
        System.out.println(minNumberInRotateArray(array));
    }
}
