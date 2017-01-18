package LeetCodeLinkedList;

public class MainLinkedList {

	public static void main(String[] args) {
		ListProblems lp = new ListProblems();
		ListNode head = new ListNode(1);
	    head = lp.createList(head);
	    lp.printList(head);
	    ListNode head2 = lp.reverseKGroup(head, 3);
	    System.out.println("");
	    lp.printList(head2);
		

	}

}
