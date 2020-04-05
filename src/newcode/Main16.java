package newcode;

public class Main16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null)return list2;
        if (list2==null)return list1;
        //思考：注意list1 list2次时是头节点
        //初始化合成链表的头结点
        ListNode headnode;
        if (list1.val<list2.val){
            headnode = list1;
            list1 = list1.next;
        }else {
            headnode = list2;
            list2 = list2.next;
        }

        ListNode removenode = headnode;
        while (list1!=null&&list2!=null){
            if (list1.val>list2.val){
                removenode.next = list2;
                removenode = list2;
                list2 = list2.next;

            }else {
                removenode.next = list1;
                removenode = list1;
                list1 = list1.next;
            }}

            while (list1!=null){
                removenode.next = list1;
                removenode = list1;
                list1 = list1.next;
            }
            while (list2!=null){
                removenode.next = list2;
                removenode = list2;
                list2 = list2.next;
            }
            return headnode;



    }
}
