package Linked;

/**
 * @author dcg
 * Created by user on 2018/5/21.
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedList(){
        dummyHead=new Node();
        size=0;
    }
    //获取链表中的个数
    public int getSize(){
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //在链表0-based位置中添加新的元素
    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node pre=dummyHead;
        for (int i=0;i<index;i++){
            pre=pre.next;
        }
        pre.next=new Node(e,pre.next);
        size++;
    }
    //在链表头部添加
    public void addFirst(E e){
        add(0,e);
    }
    //z在链表尾部添加
    public void addLast(E e){
        add(size,e);
    }
    // 获得链表的第index(0-based)个位置的元素
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node cur=dummyHead;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.e;
    }
    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }
    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        Node retNode=prev.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }
    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }
    // 从链表中删除元素e
    public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}
