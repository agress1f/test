package newcode;

import java.util.Stack;

public class Main21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex<pushA.length){
            if (!stack.isEmpty()&&stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }else {
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }

        }

        while (!stack.isEmpty()){
            if (stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }else {
                return false;
            }
        }
        return true;
    }
}
