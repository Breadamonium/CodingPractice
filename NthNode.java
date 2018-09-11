class NthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode answer = null;
        int i = 1;
        int countNodes = 0;
        while (current.next != null) {
            countNodes++;
        }
        while (current.next != null) {
            if (n == 1) {
                answer = head.next;
            } else {
                answer = head;
            }
            if (i == (countNodes - n)) {
                ListNode prev = current;
                current = current.next;
                if (current.next != null) {
                    prev.next = current.next;
                } 
                else {
                    prev.next = null;
                    break;
                }
            } else {
                current = current.next;
            }
            i++;
        }
        return answer;
    }
}