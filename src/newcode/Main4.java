package newcode;



class TreNode{
    int val;
    TreNode left;
    TreNode right;
    TreNode(int x){
        val = x;
    }
}
public class Main4 {
    private static int index = 0;

    //pre 前序
    //tempIn 中序
    private static TreNode solve(int[] pre,int[] tempIn){
        int len1 =0;//左子树节点个数
        int len2 =0;//有字数节点个数

        for (int i =0;i<tempIn.length;i++){
            //pre[index=0]是root,先确定其在中序的位置，来确定左右子树元素
            if (pre[index]==tempIn[i])
                break;//在中序中找到root跳出for
            len1++;//左子树长度增加
        }
        len2 =tempIn.length-len1-1;
        int index1 = 0;
        int index2 = 0;
        int[] temp1 = new int[len1];//left
        int[] temp2 = new int[len2];//right
        boolean flag = false;
        //分别将左右子树存入 temp1和temp2
        for (int i = 0;i<tempIn.length;i++){
            if (pre[index]==tempIn[i]){
                flag = true;
            }else if(!flag){
                temp1[index1++]=tempIn[i];
            }else {
                temp2[index2++]=tempIn[i];
            }
        }


        TreNode node = new TreNode(pre[index]);//创建根,前序index=0时
        node.right = null;
        node.left = null;

        if (index<pre.length && temp1.length>0){
            index++;
            node.left = solve(pre,temp1);//创建左子树
        }
        if (index<pre.length && temp2.length>0){
            index++;
            node.right = solve(pre,temp2);//创建右子树
        }
        return node;
    }



    public static TreNode reConstructBinaryTree(int [] pre, int [] in) {
        index = 0;
        return solve(pre,in);

    }
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreNode root = reConstructBinaryTree(pre,in);
        dfs1(root);
        System.out.println();
        dfs2(root);
        System.out.println();
        dfs3(root);
        System.out.println();
    }

    private static void dfs1(TreNode node){
        System.out.printf("%d",node.val);
        if(node.left!=null){
            dfs1(node.left);
        }
        if (node.right !=null){
            dfs1(node.right);
        }
    }
    private static void dfs3(TreNode node){
        if (node.left!=null){
            dfs3(node.left);
        }

        if (node.right!=null){
            dfs3(node.right);
        }
        System.out.printf("%d",node.val);
    }
    private static void dfs2(TreNode node){
        if (node.left!=null){
            dfs2(node.left);
        }
        System.out.printf("%d",node.val);
        if (node.right!=null){
            dfs2(node.right);
        }
    }
}
