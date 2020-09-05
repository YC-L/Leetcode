// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

// 示例：

// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

// 示例：

// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 并行循环，非递归写法
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list, cur;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1.val <= l2.val){
            list = l1;
            l1 = l1.next;
        }else{
            list = l2;
            l2 = l2.next;
        }               
        cur = list; 
        while(l1 != null || l2 != null){
            if(l1 == null && l2 != null){               
                cur.next = l2;
                l2 = l2.next;                
            }
            if(l1 != null && l2 == null){              
                cur.next = l1;
                l1 = l1.next;
            }
            if(l1 != null && l2 != null){   
                if(l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;                
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
            }      
            cur = cur.next;             
        }
        return list;
    }
}
// 递归写法
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode res = l1.val < l2.val ? l1 : l2;
    res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
    return res;
}