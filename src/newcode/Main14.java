package newcode;

import java.util.Stack;

public class Main14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
//        Stack<ListNode> stack =new Stack<>();
//        while (head.next!=null){
//            stack.push(head);
//            head = head.next;
//
//        }
//        int sum = 1;
//        if (stack.empty()){
//            System.out.println("{}");
//        }
//        while (!stack.empty()){
//            if (sum==k){
//                return stack.pop();
//            }else {
//                stack.pop();
//                sum++;
//            }
//
//        }
//        return null;
//    }

            if(head==null || k<=0)
                return null;
            int numbOfList=1;
            Stack<ListNode> st = new Stack<ListNode>();
            st.push(head);
            ListNode node=head.next;
            while(node!=null){
                numbOfList++;
                st.push(node);
                node=node.next;
            }
            if(k>numbOfList)
                return null;
            else{
                for(int i=1;i<=k;i++){
                    node=st.pop();
                }
                return node;
            }
        }

        public static void main(String[] args){

        }
}
