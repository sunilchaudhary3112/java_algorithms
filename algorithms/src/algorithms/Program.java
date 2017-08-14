package algorithms;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Java Configuration");
		/*LinkedList list = new LinkedList();
		list.insertAtBegin(4);
		list.insertAtBegin(3);
		list.insertAtBegin(2);
		list.insertAtBegin(1);
		list.insertAtEnd(7);
		list.insertAfterMatch(5, 4);
		list.insertAfterMatch(8, 7);
		list.insertAfterPos(6, 5);
		System.out.println("length of list :" + list.length);
		list.removeFromEnd();
		list.removeFromEnd();
		list.removeGivenKey(3);
		System.out.println("length of list :" + list.length);
		list.display();
		LNode node = list.reverseRecurrsion(list.head, null);
		System.out.println("Reversing the list");
		list.display();*/
		
		// Merge 2 list
//		LinkedList l1 = new LinkedList();
//		l1.insertAtBegin(1);
//		l1.insertAtEnd(5);
//		l1.insertAtEnd(10);
//		l1.insertAtEnd(15);
//		l1.insertAtEnd(20);
//		l1.insertAtEnd(30);
//		LinkedList l2 = new LinkedList();
//		l2.insertAtBegin(2);
//		l2.insertAtEnd(7);
//		l2.insertAtEnd(14);
//		l2.insertAtEnd(29);
//		l2.insertAtEnd(35);
//		LinkedList l3 = new LinkedList();
//		l3.head = l3.mergeListRec(l1.head, l2.head);
//		l3.length = l1.length + l2.length;
//		l3.display();
		
		//Reverse-a-list-in-groups-of-given-size
		/*LinkedList l1 = new LinkedList();
		l1.insertAtBegin(1);
		l1.insertAtEnd(2);
		l1.insertAtEnd(3);
		l1.insertAtEnd(4);
		l1.insertAtEnd(5);
		l1.insertAtEnd(6);
		l1.insertAtEnd(7);
		l1.head = l1.revereKGoupInList(l1.head, 3);
		l1.display();*/
		
		/*LinkedList list = new LinkedList();
        list.head = new LNode(50);
        list.head.next = new LNode(20);
        list.head.next.next = new LNode(15);
        list.head.next.next.next = new LNode(4);
        list.head.next.next.next.next = new LNode(10);
        list.length = 5;
        // Creating a loop for testing 
        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemoveLoop();
        list.display();*/
		
		//Add two List
//		LinkedList list1 = new LinkedList();
//		list1.insertAtBegin(1);
//		list1.insertAtEnd(2);
//		list1.insertAtEnd(3);
//		LinkedList list2 = new LinkedList();
//		list2.insertAtBegin(9);
//		list2.insertAtEnd(9);
//		list2.insertAtEnd(9);
//		LinkedList l3 = new LinkedList();
//		l3.head = l3.addTwoList(list1.head, list2.head);
//		l3.display();
		
		//CircularList
		CircularList CList = new CircularList();
		//AddNode
		CList.addNode(1);
		CList.addNode(2);
		CList.addNode(3);
		CList.addNode(4);
		CList.addNode(5);
		CList.deleteNodeAtEnd();
		CList.deleteNodeAtEnd();
		CList.deleteNodeAtEnd();
		CList.addNode(3);
		CList.addNode(4);
		CList.addNode(5);
		//Display list
		CList.display();
		
	}

}
