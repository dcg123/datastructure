package PreOrderTraverseInBST;

/**
 * @author dcg
 * Created by user on 2018/5/24.
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    //定义根节点
    private Node root;
    private int size;
    public BST(){
        size=0;
        root=null;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向二叉树中添加节点
    public void add(E e){
        //判断是否含有根节点
        if(root==null){
            root=new Node(e);
            size++;
        }
        else {
            add(root,e);
        }
    }
    // 向以node为根的二分搜索树中插入元素e，递归算法
    public void add(Node node,E e){
        if (e.equals(node.e)){
            return;
        }else if (e.compareTo(node.e)<0&&node.left==null){
            node.left=new Node(e);
            size++;
            return;
        }else if (e.compareTo(node.e)>0&&node.right==null){
            node.right=new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e)<0){
            add(node.left,e);
        }else {
            add(node.right,e);
        }
    }

    //二分搜索树中是否包含e元素 递归
    public boolean contains(Node node,E e ){
        if(node == null)
            return false;
        if (e.equals(node.e)){
            return true;
        }
        else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }

    //前序遍历
    public void preOrder(Node node){
        if (node.e==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }



    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
