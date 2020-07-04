package leetcode;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/6/2
 * Time: 20:17
 * Description: No Description
 */
public class test31 {
    public static void main(String[] args) {
        int[] pushed = {2,3,0,1};
        int[] popped = {0,3,2,1};
        boolean res = validateStackSequences(pushed,popped);
        System.out.println(res);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0&&popped.length==0) return true;
        if(pushed.length==0||popped.length==0) return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while(i<pushed.length && j<popped.length){
            if(stack.isEmpty()&&pushed[i]!=popped[j]){
                stack.push(pushed[i]);
                i++;
            }

            if(pushed[i]!=popped[j]){
                if(stack.peek()==popped[j]){
                    stack.pop();
                    j++;
                }else {
                    stack.push(pushed[i]);
                    i++;
                }
            }else{
                stack.push(pushed[i]);
                stack.pop();
                i++;
                j++;

            }


        }


        while(!stack.isEmpty()&&j<popped.length){
            if(stack.peek()!=popped[j]){
                return false;
            }else{
                stack.pop();
                j++;
            }
        }
        return true;

    }
}
