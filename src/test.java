import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/5/28
 * Time: 18:12
 * Description: No Description
 */
public class test {
    public static void main(String[] args) {
        //构建一个链表
        ListNode head = new ListNode(0);
        ListNode moveNode = head;
        for (int i =1;i<10;i++){
            ListNode x = new ListNode(i);
            x.next = null;
            moveNode.next = x;
            moveNode = x;
        }
        ListNode temp = head;
        print(temp);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = printListFromTailToHead(list,head);
        System.out.println(res);


    }


    public static ArrayList<Integer> printListFromTailToHead(ArrayList<Integer> list,ListNode listNode) {

        if (listNode!=null){
            ListNode head = listNode;
            ListNode tail = listNode.next;
            printListFromTailToHead(list,tail);
            list.add(head.val);
        }else{
            System.out.print('.');
        }

        return list;
    }

    public static void print(ListNode listNode){
        //顺序打印
        ArrayList<Integer> list1 = new ArrayList<>();
        do {
            //System.out.println(head.val);
            list1.add(listNode.val);
            listNode = listNode.next;
        } while (listNode!=null);
        System.out.println("正常顺序");
        System.out.println(list1);
    }
}




class ListNode{
    int val;
    ListNode next  = null;
    ListNode(int val){
        this.val = val;
    }
}