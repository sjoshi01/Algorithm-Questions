package LeetCodeLinkedList;

public class ReverseKGroupLinkedList {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
          return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode nextNode = dummy;
        while(true)
        {
            int count =0;
            while(nextNode != null && count < k)
            {
                nextNode = nextNode.next;
                count++;
            }
            if(nextNode == null)
              break;
            ListNode nextCycle = prev.next;
            while(prev.next != nextNode)
            {
                ListNode temp = prev.next;
                prev.next = temp.next;
                temp.next = nextNode.next;
                nextNode.next = temp;
            }
            nextNode = nextCycle;
            prev = nextCycle;
        }
        return dummy.next;
    }
}
