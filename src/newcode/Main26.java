package newcode;

public class Main26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //
    private TreeNode ans;
    private TreeNode removeNode;
    private void dfs(TreeNode node,int flag){
        if (node.left!=null){
            dfs(node.left,0);
        }
        if (ans==null){
            ans = node;
            removeNode = node;
        }else {
            removeNode.right = node;
            node.left = removeNode;
            removeNode = node;
        }
        if (node.right!=null){
            dfs(node.right,1);
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
        ans = null;
        removeNode = null;
        dfs(pRootOfTree,0);
        return ans;
    }
}
