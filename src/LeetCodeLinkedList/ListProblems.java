package LeetCodeLinkedList;

public class ListProblems {
	ListNode head= new ListNode(1);

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
  
   
   void printList(ListNode head)
   {
	   if(head == null)
		   return;
	   while(head != null)
	   {
		   System.out.print(""+ head.val+ " - " );
		   head = head.next;
	   }
   }
   
   ListNode createList(ListNode head)
   {
	   ListNode two = new ListNode(2);
	   ListNode three = new ListNode(3);
	   ListNode four = new ListNode(4);
	   ListNode five = new ListNode(5);
	   ListNode six = new ListNode(6);
	   head.next = two;
	   two.next = three;
	   three.next = four;
	   four.next = five;
	   //five.next = six;
	   return head;
   }
   
}
