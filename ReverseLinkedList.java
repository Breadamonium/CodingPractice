//https://leetcode.com/problems/reverse-linked-list/submissions/ #206
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode tempCurrentNext = head.next;
        head.next = null; 
        while(tempCurrentNext!=null) { 
            ListNode temp = tempCurrentNext.next; 
            tempCurrentNext.next = current;
            current = tempCurrentNext; 
            tempCurrentNext = temp; 
        }
        return current;
    }
}