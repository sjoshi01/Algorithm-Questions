package LeetCodeLinkedList;

public class ReverseKGroupLinkedList {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
          return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode nextNode = dummy;
        while(true)//Need to repeate this loop till the end of linkedList
        {
            int count =0;
            while(nextNode != null && count < k)
            {
                nextNode = nextNode.next;
                count++;
            }
            if(nextNode == null)
              break;
            ListNode nextCycle = prev.next; // when K group nodes are reversed, prev.next will become starting node for next group
            while(prev.next != nextNode)//loop till current group last element doesn't updated to current prev's next node
            {
                ListNode temp = prev.next;
                prev.next = temp.next;
                temp.next = nextNode.next;
                nextNode.next = temp;
            }
            nextNode = nextCycle;//for next group prev node will be current prev's next which updated to end of current group after reverse
            prev = nextCycle;
        }
        return dummy.next;
    }
}
