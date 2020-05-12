package datastructure;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4,6,8,5,9};
        heapSort(arr);
    }
    //编写一个堆排序的方法
    public static void heapSort(int arr[]){
        int temp=0;
        System.out.println("堆排序！");
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次"+ Arrays.toString(arr));
//        adjustHeap(arr,0);
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //将堆顶元素与末尾元素交换将最大元素沉到数组末端
        //重新调整结构使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行
        for (int j=arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j]  = arr[0];
            arr[0]  = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("数组"+Arrays.toString(arr));

    }

    //将一个数组，调整成一个大顶堆
    /*arr待调整的数组
     *将以i为对应的非叶子节点调整成大顶堆46859=>49856
     *  i 表示叶子结点在数组中的索引
     * length表示多少个元素继续调整，length在逐渐减少
    */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];//先取出当前元素的值，保存临时便利
        //开始调整
        //说明
        //1.k=i*2+1 k是i的左子节点
        for (int k =i*2+1;k<length;k=2*k+1){
            if (k+1<length&&arr[k]<arr[k+1]){
                k++;//找出左右子节点中最大的
            }
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值放在了局部
        arr[i] = temp;//将temp值放到调整后的位置
    }

}
