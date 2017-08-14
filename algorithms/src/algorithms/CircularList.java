package algorithms;

public class CircularList {
	CNode head;
	int length;
	public CircularList() {
		// TODO Auto-generated constructor stub
		head = null;
		length = 0;
	}
	public void display(){
		CNode currentNode = head;
		for(int i = 0; i < length && currentNode != null; i++){
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}
	
	public void addNode(int dataToAdd){
		CNode newNode = new CNode(dataToAdd);
		if(head == null || length == 0){
			head = newNode;
			newNode.next = head;
			length++;
		}else{
			CNode currentNode = head;
			while(currentNode.next != head){
				currentNode = currentNode.next;
			}
			newNode.next = head;
			currentNode.next = newNode;
			length++;
		}
	}
	
	public void deleteNodeAtEnd(){
		if(head == null){
			return;
		}
		if(length == 1){
			 head = null;
			 length--;
		}else{
			CNode currentNode = head;
			CNode prevNode = currentNode;
			while(currentNode.next != head){
				prevNode = currentNode;
				currentNode = currentNode.next;
			}
			prevNode.next = currentNode.next;
			length--;
		}
	}
}
