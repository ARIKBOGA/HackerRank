
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

class TwoSumLinkedList {
    public int lengthOfLongestSubstring(String s) {
        String sub="";
        String temp="";
        for(int i = 0; i < s.length(); i++){
            if(!temp.contains(String.valueOf(s.charAt(i)))){
                temp += s.charAt(i);
            }else{
                if(temp.length() > sub.length()){
                    sub = temp;
                    s=s.substring(i+1);
                }
                temp="";
            }
        }
        return sub.length();
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode l3 = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            boolean l1A = l1 == null;
            boolean l2A = l2 == null;
            int sum = (l1A ? 0 : l1.val) + (l2A ? 0 : l2.val) + carry;
            carry = sum / 10;
            l3.next = new ListNode(sum % 10);
            l1 = l1A ? null : l1.next;
            l2 = l2A ? null : l2.next;
            l3 = l3.next;
        }
        if (carry == 1) l3.next = new ListNode(1);
        return head.next;
    }
}