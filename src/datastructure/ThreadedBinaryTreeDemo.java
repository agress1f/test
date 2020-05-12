package datastructure;

import jdk.nashorn.internal.ir.ThrowNode;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试
        HeroNode1 root = new HeroNode1(1,"tom");
        HeroNode1 node2 = new HeroNode1(3,"jack");
        HeroNode1 node3 = new HeroNode1(6,"smith");
        HeroNode1 node4 = new HeroNode1(8,"mary");
        HeroNode1 node5 = new HeroNode1(10,"king");
        HeroNode1 node6 = new HeroNode1(14,"dim");
        //二叉树，后面递归，现在手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        //测试线索化
        ThreadedBinaryTree1 threadedBinaryTree1 =new ThreadedBinaryTree1();
        threadedBinaryTree1.setRoot(root);
        //中序线索化
        //threadedBinaryTree1.threadedNodes();
        //前序线索化
        threadedBinaryTree1.preThreadedNodes();
        //以十号节点做测试
        HeroNode1 node = node6.getLeft();
        System.out.println(node);
        //
        //System.out.println("线索化遍历");
        //threadedBinaryTree1.infixThreadedList();
    }
}

class ThreadedBinaryTree1{
    private HeroNode1 root;
    //为了实现线索化，需要创建要给指向当前节点的前驱节点的指针
    //在递归进行线索化时，pre总是保留前一个节点
    private HeroNode1 pre =null;
    public void setRoot(HeroNode1 root){
        this.root = root;
    }

    //重载threadedNodes（）方法
    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void preThreadedNodes(){
        this.preThreadedNodes(root);
    }

    //遍历中序线索化二叉树的方法
    public void infixThreadedList(){
        HeroNode1 node = root;
        while (node!=null){
            //循环得找到leftType==1的节点，第一个找到的8节点
            //后面随着便利的而变化，因为当leftType==1，说明该节点是按照线索化
            //处理后的有效节点
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
    //遍历前序线索化二叉树的方法
    public void preThreadedList(){
        HeroNode1 node = root;
        while (node!=null){
            //循环得找到leftType==1的节点，第一个找到的8节点
            //后面随着便利的而变化，因为当leftType==1，说明该节点是按照线索化
            //处理后的有效节点
            System.out.println(node);
            while (node.getLeftType()==0){
                node = node.getLeft();
            }

            while (node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //中序线索化的方法
    public void threadedNodes(HeroNode1 node){
        //如果node==null,不能线索化
        if (node==null){
            return;
        }
        //（一）先线索化左子树
        threadedNodes(node.getLeft());
        //（二）线索化当前节点[难度]
        //先处理当前节点的前驱节点
        if (node.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre!=null&&pre.getRight()==null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的指针类型
            pre.setRightType(1);
        }
        //处理一个节点后，让当前节点试下一个节点的前驱节点
        pre = node;
        // (三)线索化右子树
        threadedNodes(node.getRight());
    }


    //前序线索化的方法
    //?
    public void preThreadedNodes(HeroNode1 node){
        //如果node==null,不能线索化
        if (node==null){
            return;
        }
        //（二）线索化当前节点[难度]
        //先处理当前节点的前驱节点
        if (node.getLeft()==null){
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //处理后继节点
        if (pre!=null && pre.getRight()==null){
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的指针类型
            pre.setRightType(1);
        }
        //处理一个节点后，让当前节点试下一个节点的前驱节点
        pre = node;
        //（一）先线索化左子树
        if (node.getLeftType()!=1) {
            preThreadedNodes(node.getLeft());
        }

        // (三)线索化右子树
        if (node.getRightType()!=1) {
            preThreadedNodes(node.getRight());
        }
    }

    //删除节点
    public void delNode(int no){
        if (root!=null){
            //如果只有一个root节点，这里理解判断root是不是删除节点
            if (root.getNo()==no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除~");
        }
    }

    //前序
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public HeroNode1 preOrderSearch(int no){
        if (root!=null){
            return root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode1 infixOrderSearch(int no){
        if (root!=null){
            return root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode1 postOrderSearch(int no){
        if (root!=null){
            return root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

class HeroNode1  {
    private int no;
    private String name;
    private HeroNode1 left;
    private HeroNode1 right;


    //leftType==0表示左子树，1表示指向前驱节点
    //rightType==0表示右子树，1表示后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode1(int no, String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode1 getLeft() {
        return left;
    }

    public void setLeft(HeroNode1 left) {
        this.left = left;
    }

    public HeroNode1 getRight() {
        return right;
    }

    public void setRight(HeroNode1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }



    public void delNode(int no){
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }


    //编写前序遍历
    public void preOrder(){

        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //编写中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //编写后序遍历
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    /*
     *no查找no
     * 没有就返回null
     *
     */
    public HeroNode1 preOrderSearch(int no){
        System.out.println("进入前序遍历");
        //比较当前节点是不是
        if (this.no==no){
            return this;
        }
        //判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到节点，则返回
        HeroNode1 resNode = null;
        if (this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        //左子树找到
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode1 infixOrderSearch(int no){
        //判断当前节点的左子节点是否为空，如果不为空，则递归中序查找
        HeroNode1 resNode = null;
        if (this.left!=null){
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        System.out.println("进入中序查找");
        if (this.no==no){
            return this;
        }
        //否则继续进行右递归的中序查找
        if (this.right!=null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode1 postOrderSearch(int no){
        HeroNode1 resNode = null;
        if (this.left!=null){
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        //如果左右子树都没有找到，就比较当前节点是不是
        System.out.println("进入后序查找");
        if (this.no==no){
            return this;
        }
        return resNode;
    }
}