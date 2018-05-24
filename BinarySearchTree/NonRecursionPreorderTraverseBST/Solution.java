package NonRecursionPreorderTraverseBST;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author dcg
 * Created by user on 2018/5/24.
 * /// Leetcode 144. Binary Tree Preorder Traversal
 * /// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * 非递归前序遍历实现
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null){
            return res;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }
        return res;
    }
}
