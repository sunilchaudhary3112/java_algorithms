package algorithms;

public class DoublyList {
	DNode head;
	int length;

	public DoublyList() {
		// TODO Auto-generated constructor stub
		head = null;
		length = 0;
	}

	public void display() {
		if (length == 0) {
			return;
		} else {
			DNode currentNode = head;
			while (currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}

	public void addNodeAtBegin(int dataToAdd) {
		DNode newNode = new DNode(dataToAdd);
		if (head == null || length == 0) {
			head = newNode;
			length++;
		} else {
			head.prev = newNode;
			newNode.next = head;
			length++;
			head = newNode;
		}
	}

	public void AddNodeAtEnd(int dataToAdd) {
		DNode newNode = new DNode(dataToAdd);
		if (length == 0) {
			addNodeAtBegin(dataToAdd);
			return;
		}
		DNode currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		newNode.prev = currentNode;
		length++;
	}

	public void DeleteNodeAtBegin() {
		if (head == null || length == 0) {
			return;
		}

		System.out.println("Node Deleted " + head.data);
		if (length == 1) {
			head = null;
		} else {
			head = head.next;
		}
		length--;
	}

}
