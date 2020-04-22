package newcode;

public class Main56 {
    //判断重复节点，后移指针
    private ListNode change(ListNode x) {
        int temp = x.val;
        while (x!=null && x.val == temp){
            x = x.next;
        }
        return x;
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode ans = pHead;

        while (ans.next!=null){
            if (ans.next!=null && ans.val==ans.next.val){
                //后移指针
                ans = change(ans);
            }else {
                //找到头节点，跳出
                break;
            }
        }
        //空链表
        if (ans == null){
            return null;
        }


        ListNode lastNode = ans;
        ListNode removeNode = lastNode.next;

        while (removeNode != null){
            if (removeNode.next!=null && removeNode.val==removeNode.next.val){

                removeNode = change(removeNode);
            }else {
                lastNode.next = removeNode;
                lastNode = removeNode;
                removeNode = removeNode.next;
            }
        }
        lastNode.next = null;
        return ans;

    }
}
