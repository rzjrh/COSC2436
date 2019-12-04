//modify the node class and add previous
public class Node {
	
	public long dData; 
	public Node next; 
	public Node previous; 
	public Node(long d) 
	{ dData = d; }
	public void displayLinkedList() 
	{ System.out.print(dData + " "); }

}
