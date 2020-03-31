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
    private static TreNode solve(int[] pre,int[] tempIn){
        int len1 =0;//左子树节点个数
        int len2 =0;//有字数节点个数

        for (int i =0;i<tempIn.length;i++){
            if (pre[index]==tempIn[i])
                break;
            len1++;
        }
        len2 =tempIn.length-len1-1;
        int index1 = 0;
        int index2 = 0;
        int[] temp1 = new int[len1];//left
        int[] temp2 = new int[len2];//right
        boolean flag = false;
        for (int i = 0;i<tempIn.length;i++){
            if (pre[index]==tempIn[i]){
                flag = true;
            }else if(!flag){
                temp1[index1++]=tempIn[i];
            }else {
                temp2[index2++]=tempIn[i];
            }
        }
        TreNode node = new TreNode(pre[index]);
        node.right = null;
        node.left = null;
        if (index<pre.length&&temp1.length>0){
            index++;
            node.left = solve(pre,temp1);
        }
        if (index<pre.length && temp2.length>0){
            index++;
            node.right = solve(pre,temp2);
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
