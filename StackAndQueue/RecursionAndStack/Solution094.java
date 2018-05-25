package RecursionAndStack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * /// 94. Binary Tree Inorder Traversal
 /// https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
 /// 二叉树的中序遍历
 /// 时间复杂度: O(n), n为树的节点个数
 /// 空间复杂度: O(h), h为树的高度
 */
public class Solution094 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node,List<Integer> res){
//        if (node!=null){
//            inorderTraversal(node.left,res);
//            res.add(node.val);
//            inorderTraversal(node.right,res);
//        }

    }



}
