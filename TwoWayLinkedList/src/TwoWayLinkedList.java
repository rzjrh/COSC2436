import java.util.ListIterator;
class TwoWayLinkedList<E> extends java.util.AbstractSequentialList<E>
{
   
	private Node<E> head, tail;
	private int listSize;
	
   public TwoWayLinkedList(){}
  
   public E getFirst()
   {
       if (listSize == 0)
       {
           return null;
       }
       else {
           return head.element;
       }
   }
  
   public E getLast()
   {
       if (listSize == 0)
       {
           return null;
       }
      
       else
       {
           return tail.element;
       }
   }
   public void addFirst(E data)
   {
       Node<E> ourListNode = new Node<E>(data);
      
       ourListNode.next = head;
       head = ourListNode;
       listSize++;
      
       if (tail == null)
           tail = head;
      
       if (head != tail)          
           head.next.previousNode = head;
   }
  
   public void addLast(E data)
   {
       Node<E> ourListNode = new Node<E>(data);
       Node<E> temp = tail;
      
       if (tail == null){
           head = tail = ourListNode;
       }
      
       else {
           tail.next = ourListNode;
           tail = tail.next;
       }
           listSize++;
           tail.previousNode = temp;
   }
  
   public void add(int indexA, E data)
   {
       if (indexA == 0){
           addFirst(data);
       }
      
       if (indexA >= listSize){
           addLast(data);
       }
      
       else
       {
           Node<E> presentNode = head;
          
           for (int idx1 = 1; idx1 < indexA; idx1++)
           {
               presentNode = presentNode.next;
           }
          
           Node<E> temp = presentNode.next;
          
           presentNode.next = new Node<E>(data);
           (presentNode.next).next = temp;          
           listSize++;
           temp.previousNode = presentNode.next;          
           presentNode.next.previousNode = presentNode;
       }
   }
      
   public E removeFirst()
   {
       if (listSize == 0)
       {
           return null;
       }
       else {
           Node<E> temp = head;
           head = head.next;          
           listSize--;          
           if (head == null)
           {
               tail = null;
           }          
           return temp.element;
       }
   }
  
   public E removeLast()
   {
       if (listSize == 0)
       {
           return null;
       }
      
       if (listSize == 1)
       {
           Node<E> temp = head;         
           head = tail = null;          
           listSize = 0;          
           return temp.element;
       }
      
       else
       {
           Node<E> presentNode = head;
          
           for (int idx1 = 0; idx1 < listSize - 2; idx1++)
           {
               presentNode = presentNode.next;
           }
          
           Node<E> temp = tail;
           tail = presentNode;          
           tail.next = null;          
           listSize--;
          
           return temp.element;
       }
   }
  
   public E remove(int indexA)
   {
       if (indexA < 0 || indexA >= listSize)
       {
           return null;
       }
      
       if (indexA == 0)
       {
           return removeFirst();
       }
             if (indexA == listSize - 1)
       {
           return removeLast();
       }
      
       else {
           Node<E> previousNode = head;
          
           for (int idx1 = 1; idx1 < indexA; idx1++)
           {
               previousNode = previousNode.next;
           }
          
           Node<E> presentNode = previousNode.next;
                   previousNode.next = presentNode.next;
          
           presentNode.next.previousNode = previousNode;
                     listSize--;
                     return presentNode.element;
       }
   }
  
   @Override
   public String toString()
   {
       StringBuilder sbObject = new StringBuilder("[");
             Node<E> presentNode = head;
             for (int idx1 = 0; idx1 < listSize; idx1++)
       {  
           sbObject.append(presentNode.element);
          
           presentNode = presentNode.next;
                     if (presentNode != null)
           {
               sbObject.append(", ");
           }
          
           else
           {
               sbObject.append("]");
           }
       }
      
       return sbObject.toString();
   }
  
   public void clear()
   {
       head = tail = null;
   }
  
   public boolean contains(Object data)
   {
       Node<E> presentNode = head;
      
       while(presentNode!=null)
       {
           if(data.equals(presentNode.element))
              
               return true;
          
           presentNode=presentNode.next;
       }
      
       return false;
   }
  
   public E get(int indexA)
   {      
       Node<E> presentNode = head;
      
       if(indexA>listSize)          
           return null;     
       for (int idx1 = 0; idx1 < indexA; idx1++)
       {
           presentNode=presentNode.next;
       }      
       return presentNode.element;
   }
  
   public int indexOf(Object data)
   {
       Node<E> presentNode = head;
      
       int indData=0;
      
       while(presentNode!=null)
       {          
           if(presentNode.element.equals(data))              
               return indData;         
           presentNode=presentNode.next;          
           indData++;
       }      
       return indData;
   }
  
   public int lastIndexOf(Object data)
   {
       Node<E> presentNode = tail;
      
       int indData=listSize-1;
      
       while(presentNode!=null && (data.equals(presentNode.element)))
       {
           presentNode=presentNode.previousNode;
          
           indData--;
       }
      
       if(presentNode==null)
       {
           return -1;
       }      
       return indData;
   }
  
   public E set(int indexA, E data)
   {
       if(indexA>listSize )          
           return null;     
       Node<E> presentNode = head;      
       while(indexA>0)
       {
           presentNode=presentNode.next;          
           indexA--;
       }
      
       E temp1=presentNode.element;      
       presentNode.element=data;
      
       return temp1;
   }
  
   public java.util.ListIterator<E> iterator()
   {
       return new ListIteratorDLL<E>();
   }
  
   public class ListIteratorDLL<E> implements java.util.ListIterator<E> {
		
	   
       private Node<E> presentNode = (Node<E>)head;
      
       int indData = 0;      
       public ListIteratorDLL(){}      
       public ListIteratorDLL(int indexA){
           if (indexA < 0 || indexA > listSize)             
               throw new IndexOutOfBoundsException("Index: " + indexA + ", Size: "+ listSize);
                     for (int idx1 = 0; idx1 < indexA; idx1++)
                     presentNode = presentNode.next;
       }
      
       public boolean hasNext(){
           return (presentNode != null);
       }
      
       public E next(){
           E data = presentNode.element;
           presentNode = presentNode.next;
           indData++;          
           return data;
       }
      
       public void remove() {
           Node<E> temp1=presentNode.previousNode;         
           Node<E> temp2=presentNode.next;         
           temp1.next=temp2;          
           temp2.previousNode=temp1;         
           presentNode=temp1;          
           indData--;
       }
      
       public void add(E data) {
           Node<E> temp1=presentNode.previousNode;
           Node<E> temp2=new Node(data);
           Node<E> temp3=presentNode;
           temp1.next=temp2;
           temp2.next=temp3;
           temp3.previousNode=temp2;
           temp2.previousNode=temp1;
           indData++;
       }
      
       public boolean hasPrevious(){
           return presentNode != head;
       }
      
       public int nextIndex(){      
           return indData;
       }
      
       public E previous(){
           E data = presentNode.element;
           presentNode = presentNode.previousNode;
           return data;
       }
      
       public int previousIndex(){
           return indData-1;
       }
      
       @Override
       public void set(E data)
       {
           presentNode.element = data;
       }
   }
  
   public int size()
   {
       return listSize;
   }
  
   public ListIterator<E> listIterator(int indexA)
   {
       return new ListIteratorDLL<E>(indexA);
   }
}