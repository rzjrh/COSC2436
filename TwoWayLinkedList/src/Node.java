
public class Node<E>
   {
       E element;
       Node<E> next;
       Node<E> previousNode;
      
       public Node(E data)
       {
           element = data;
       }
   }