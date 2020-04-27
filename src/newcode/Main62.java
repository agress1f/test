package newcode;

public class Main62 {

    private TreeNode ans;
    private int index;
    public TreeNode KthNode(TreeNode pRoot, int k) {
        index = 1;
        ans=null;
        if (k!=0&&pRoot!=null){
        solve(pRoot,k);
        }
        return ans;
    }

    private  void solve(TreeNode node, int k) {

        if (ans==null) {
            if (node.left != null) {
                solve(node.left, k);
            }
            if (index == k) {
                ans = node;
            }
            index++;
            if (node.right != null) {
                solve(node.right, k);
            }
        }
    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
