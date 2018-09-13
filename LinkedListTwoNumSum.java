class LinkedListTwoNumSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int answer = 0;
        int aCount = 0;
        int bCount = 0;
        while(l1.next!=null) {
            answer += (int) Math.pow(10, aCount)*l1.val;
            aCount++;
        }
        while(l2.next!=null) {
            answer += (int) Math.pow(10, bCount)*l2.val;
            bCount++;
        }        
        return buildAnswer(answer);
    }
    
    public ListNode buildAnswer(int answer) {
        String number = String.valueOf(answer);
        ListNode head = new ListNode(Character.digit(number.charAt(number.length() - 1), 10));
        ListNode ans = head;
        if(answer>=10) {
            for(int i = number.length() - 2; i >= 0; i--) {
                head.next.val = Character.digit(number.charAt(i), 10);
                head = head.next;
            }
        }
        return ans;
    }
}