// 反转一个单链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 翻转指针
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, tmp = null, pre = null;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }    
}