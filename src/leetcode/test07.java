package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: GZH
 * Date: 2020/5/31
 * Time: 17:05
 * Description: No Description
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
public class test07 {
    private static int index = 0;
    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        index  = 0;
        return solve(preorder,inorder);
    }

    private static TreeNode solve(int[] pre,int[] in){
        int len1 = 0;
        int len2 = 0;
        for(int i=0;i<in.length;i++){
            if(pre[index]==in[i]){
                break;
            }
            len1++;
        }
        len2 = in.length-len1-1;
        int index1 = 0;
        int index2 = 0;
        int[] temp1 = new int[len1];
        int[] temp2 = new int[len2];
        boolean flag = false;
        for(int i = 0;i<in.length;i++){
            if(pre[index]==in[i]){
                flag = true;
            }else if(!flag){
                temp1[index1++] = in[i];
            }else{
                temp2[index2++] = in[i];
            }
        }
        TreeNode node = new TreeNode(pre[index]);
        node.right = null;
        node.left = null;
        if(index<pre.length&&temp1.length>0){
            index++;
            node.left = solve(pre,temp1);
        }
        if(index<pre.length&&temp2.length>0){
            index++;
            node.right = solve(pre,temp2);
        }
        return node;
    }
    public static void main(String[] args) {
        int[] pre = {1,2};
        int[] in = {2,1};
        TreeNode root = buildTree(pre,in);
        dfs1(root);
        System.out.println();
        dfs2(root);
        System.out.println();
        dfs3(root);
        System.out.println();
    }

    private static void dfs1(TreeNode node){
        System.out.printf("%d",node.val);
        if(node.left!=null){
            dfs1(node.left);
        }
        if (node.right !=null){
            dfs1(node.right);
        }
    }
    private static void dfs3(TreeNode node){
        if (node.left!=null){
            dfs3(node.left);
        }

        if (node.right!=null){
            dfs3(node.right);
        }
        System.out.printf("%d",node.val);
    }
    private static void dfs2(TreeNode node){
        if (node.left!=null){
            dfs2(node.left);
        }
        System.out.printf("%d",node.val);
        if (node.right!=null){
            dfs2(node.right);
        }
    }
}
