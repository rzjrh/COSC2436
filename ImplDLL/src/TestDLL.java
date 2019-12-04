
public class TestDLL {
	
	public static void main(String[] args)
	{
	TwoWayLinkedList theList = new TwoWayLinkedList();

	theList.addHead(45); 
	theList.addHead(48);
	theList.addHead(56);

	theList.insertLast(71);
	theList.insertLast(83);
	theList.insertLast(25);

	theList.displayForward();
	theList.displayBackward();

	theList.deleteFirst();
	theList.deleteLast(); 
	theList.deleteKey(71); 

	theList.displayForward(); 

	theList.insertAfter(22, 77);
	theList.insertAfter(33, 88); 

	theList.displayForward(); 
	} 

}
