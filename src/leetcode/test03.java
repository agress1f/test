package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/5/31
 * Time: 11:52
 * Description: No Description
 */
public class test03 {
    public static void main(String[] args) {
        int a[]  =new int[]{2,1,3,1,4};
        int res = findRepeatNumber(a);
        System.out.println(res);
    }
    public static int findRepeatNumber(int[] nums) {
        int flag = -1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==i){
                continue;
            }
            if(nums[i]==nums[nums[i]]){
                flag = nums[i];
                break;
            }
            int temp = nums[i];
            nums[i] = nums[nums[i]];
            nums[temp] = temp;

        }
        int[] num =new int[2];
        num[0] = flag;
        return flag;


    }
}
