package algorithms;

class LNode {
	int data;
	LNode next;

	public LNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {

	public LNode head;
	public int length;

	public void display() {
		if (head != null) {
			LNode currentNode = head;
			for (int i = 0; currentNode != null; i++) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}

	public void insertAtBegin(int data) {
		LNode node = new LNode(data);
		node.next = head;
		head = node;
		length++;
	}

	public void insertAtEnd(int data) {
		LNode node = new LNode(data);
		if (head != null) {
			LNode currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = node;
			length++;
		} else {
			head = node;
			length++;
		}
	}

	public void insertAfterMatch(int data, int dataToMatch) {
		if (head == null) {
			insertAtBegin(data);
		} else {
			LNode node = new LNode(data);
			if (head.data == dataToMatch) {
				node.next = head.next;
				head.next = node;
				length++;
			} else {
				LNode currentNode = head;
				while (currentNode != null) {
					if (currentNode.data == dataToMatch) {
						node.next = currentNode.next;
						currentNode.next = node;
						length++;
					}
					currentNode = currentNode.next;
				}
			}
		}
	}

	public void insertAfterPos(int data, int pos) {
		if (pos < 0) {
			pos = 0;
		} else if (pos > length) {
			pos = length;
		}

		LNode currentNode = head;
		for (int i = 1; i != pos; i++) {
			currentNode = currentNode.next;
		}
		LNode node = new LNode(data);
		node.next = currentNode.next;
		currentNode.next = node;
		length++;
	}

	public void removeFromBegin() {
		if (head == null) {
			return;
		} else {
			LNode nodeToRemove = head;
			head = head.next;
			length--;
		}
	}

	public void removeFromEnd() {
		if (head == null) {
			return;
		} else if (head.next == null) {
			removeFromBegin();
		} else {
			LNode currentNode = head;
			for (int i = 1; i < length - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = null;
			length--;
		}
	}

	public void removeGivenKey(int key) {
		if (head == null) {
			return;
		} else if (head.data == key) {
			removeFromBegin();
			return;
		} else {
			LNode currentNode = head;
			LNode prev = currentNode;
			while (currentNode != null) {
				prev = currentNode;
				currentNode = currentNode.next;
				if (currentNode.data == key) {
					prev.next = currentNode.next;
					length--;
					return;
				}
			}

		}

	}

	public void swapNodes(int x, int y) {
		if (x == y) {
			return;
		}
		LNode prevX = null, currentX = head;
		while (currentX != null && currentX.data != x) {
			prevX = currentX;
			currentX = currentX.next;
		}

		LNode prevY = null, currentY = head;
		while (currentY != null && currentY.data != x) {
			prevY = currentY;
			currentY = currentY.next;
		}

		if (currentX == null || currentY == null) {
			return;
		}

		if (prevX != null) {
			prevX.next = currentY;
		} else {
			head = currentY;
		}

		if (prevY != null) {
			prevY = currentX;
		} else {
			head = currentX;
		}

		LNode temp = currentX.next;
		currentX.next = currentY.next;
		currentY.next = temp;
	}

	public void reverseIterative() {
		LNode prev = null, next = null, current = head;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public LNode reverseRecurrsion(LNode current, LNode prev) {

		if (current.next == null) {
			head = current;
			current.next = prev;
			return null;
		}

		LNode next1 = current.next;

		current.next = prev;
		reverseRecurrsion(next1, current);
		return head;
	}

	public LNode mergeListsIterative(LNode head1, LNode head2) {
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		LNode head3;
		if (head1.data <= head2.data) {
			head3 = head1;
			head1 = head1.next;
		} else {
			head3 = head2;
			head2 = head2.next;
		}
		LNode current3 = head3;
		while (head1 != null && head2 != null) {
			if (head1.data <= head2.data) {
				current3.next = head1;
				head1 = head1.next;
			} else {
				current3.next = head2;
				head2 = head2.next;
			}
			current3 = current3.next;
		}
		if (head1 == null) {
			current3.next = head2;
		} else {
			current3.next = head1;
		}
		return head3;
	}

	public LNode mergeListRec(LNode head1, LNode head2) {
		LNode head3;
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		if (head1.data <= head2.data) {
			head3 = head1;
			head3.next = mergeListRec(head1.next, head2);
		} else {
			head3 = head2;
			head3.next = mergeListRec(head1, head2.next);
		}
		return head3;
	}

	public LNode revereKGoupInList(LNode head1, int k) {
		LNode current = head1, prev = null, next = null;
		int count = 0;
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (next != null) {
			head1.next = revereKGoupInList(next, k);
		}
		return prev;
	}

	public Boolean detectAndRemoveLoop() {
		LNode slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow.data == fast.data) {
				removeLoop(slow);
				return true;
			}
		}
		return false;
	}

	public void removeLoop(LNode loopNode) {
		LNode ptr1 = head, ptr2;
		while (true) {
			ptr2 = loopNode;
			while (ptr2.next != loopNode && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}

			if (ptr2.next == ptr1) {
				break;
			}
			ptr1 = ptr1.next;
		}
		ptr2.next = null;
	}

	public LNode addTwoList(LNode head1, LNode head2) {
		LNode prev = null, result = null, tempNode;
		int carryOver = 0, sum;
		while (head1 != null && head2 != null) {

			sum = carryOver + head1.data + head2.data;

			carryOver = sum >= 10 ? 1 : 0;
			sum = sum % 10;
			tempNode = new LNode(sum);

			if (result == null) {
				result = tempNode;
			} else {
				prev.next = tempNode;
			}

			prev = tempNode;
			head1 = head1.next;
			head2 = head2.next;
		}
		if (carryOver > 0) {
			prev.next = new LNode(carryOver);
		}
		return result;
	}
}
