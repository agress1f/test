package newcode;

public class Main35 {
    private long sum;
    public int InversePairs(int [] array) {
       sum = 0;
       int l = 0;
       int r = array.length-1;
       divide(l,r,array);
       return (int)(sum%1000000007);
    }

    private void divide(int l, int r, int[] array) {
        if (l!=r) {
            //确保分割为长度为1的元素
            int mid = (l + r) >> 1;
            divide(l,mid,array);
            divide(mid+1,r,array);
            merge(l,r,mid,array);
        }
    }

    private void merge(int l,int r,int mid,int[] array){
        int i =l;
        int j =mid+1;
        int[] temp = new int[r-l+1];
        int index = 0;
        while (i<=mid&&j<=r){
            if (array[i]>array[j]){
                //分割到最后是两个元素之间的比较
                temp[index++]=array[j++];
                sum+=mid-i+1;
            }else {
                temp[index++]=array[i++];
            }
        }
        while (i<=mid){
            temp[index++]=array[i++];
        }
        while (j<=r){
            temp[index++]=array[j++];
        }
        index=0;
        for (int k=l;k<=r;k++){
            array[k]=temp[index++];
        }
    }
}
