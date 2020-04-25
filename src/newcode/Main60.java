package newcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int sum = 1;

        while (!queue.isEmpty()&&pRoot!=null){
            ArrayList<Integer> list = new ArrayList<>();
            int temp = 0;
            while (sum>0){
                TreeNode node = queue.poll();
                assert node!=null;
                list.add(node.val);
                if (node.left!=null){
                    temp++;
                    queue.add(node.left);
                }

                if(node.right!=null){
                    temp++;
                    queue.add(node.right);
                }
                sum--;
            }
            sum = temp;
            ans.add(list);
        }
        return ans;
    }
}
