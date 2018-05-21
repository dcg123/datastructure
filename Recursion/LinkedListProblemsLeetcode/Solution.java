package LinkedListProblemsLeetcode;

/**
 * @author dcg
 * Created by user on 2018/5/21.
 */



/**
 * /// Leetcode 203. Remove Linked List Elements
 * /// https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode p=dummy;
        ListNode q=head;
        while (q!=null){
            if (q.val==val){
                p.next=q.next;
            }else {
                p=p.next;
            }
            q=q.next;
        }
        return dummy.next;
    }
}
