package datastructure;

public class JosephCircle {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }

}
class CircleSingleLinkedList{
    //创建first节点，目前没有编号
    private Boy first = null;
    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("nums不正确");
            return;
        }
        Boy curBoy = null;
        for (int i=1;i<=nums;i++){
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            if (i==1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy(){
        if (first==null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号%d \n",curBoy.getNo());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }


    public void countBoy(int startNo,int countNum,int nums){
        if (first==null||startNo<1||startNo>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        Boy helper = first;
        while (true){
            if (helper.getNext()==first){
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，让first和helper指针同时的移动k-1次，然后出圈

        for (int j=0;j<startNo-1;j++){
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数时，同时移动count-1次
        //这里是一个循环操作，知道圈中只有一个节点
        while (true){
            if (helper==first){
                break;
            }
            for (int j=0;j<countNum-1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n",first.getNo());
    }
}
class Boy{
    private int no;
    private Boy next;

    //构造方法
    public Boy(int no){
        this.no = no;
    }
    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }
    public void setNo(int no) {
        this.no = no;
    }


}
