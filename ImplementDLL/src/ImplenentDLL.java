import java.util.ListIterator;
public class ImplenentDLL
{
//MAIN METHOD
   public static void main(String[] args)
   {
       TwoWayLinkedList<Integer> new2WayList = new TwoWayLinkedList<Integer>();
       new2WayList.add(1);
       new2WayList.add(2);
       new2WayList.add(3);
       new2WayList.add(4);
  
       java.util.ListIterator<Integer> new2WayListIterator = new2WayList.iterator();
       new2WayListIterator.next();
       new2WayListIterator.next();
       new2WayListIterator.next();
  
       System.out.println();
       while (new2WayListIterator.hasPrevious())
           System.out.print(new2WayListIterator.previous() + " ");
   }
}
//TWO WAY LINKED LIST
   class TwoWayLinkedList<E> extends java.util.AbstractSequentialList<E>
   {
   private Node<E> hNode, tNode; //HEAD AND TAIL NODE
   private int listSizeA;   //LIST SIZE
   public TwoWayLinkedList()
   {
   }  
   //RETURN THE FIRST ELEMENT IN THE LIST
   public E getFirst()
   {
       if (listSizeA == 0)
       {
           return null;
       }
       else
       {
           return hNode.element;
       }
   }
//RETURN THE LAST ELEMENT IN THE LIST
   public E getLast()
   {
       if (listSizeA == 0)
       {
           return null;
       }
       else
       {
           return tNode.element;
       }
   }  

   public void addFirst(E e1)
   {
//CREATE NEW NODE WITH ELEMENT e
       Node<E> newListNode = new Node<E>(e1);
       newListNode.next = hNode;
       hNode = newListNode;
       listSizeA++;
//CHECK IF HEAD IS NULL
       if (tNode == null)
           tNode = hNode;

       if (hNode != tNode)
           hNode.next.previous = hNode;
   }

  
   public void addLast(E e1)
   {
//CREATE NEW NODE WITH ELEMENT e
       Node<E> newListNode = new Node<E>(e1);
       Node<E> t = tNode;
//CHECK IF TAIL IS NULL
       if (tNode == null)
       {
           hNode = tNode = newListNode;
       }
//ADD NEW NODE AS LAST NODE IN THE LIST
       else
       {
           tNode.next = newListNode;
           tNode = tNode.next;
       }

       listSizeA++;
       tNode.previous = t;
   }

   public void add(int index1, E e1)
   {
//CHECK WHERE TO INSERT
       if (index1 == 0)
       {
//ADD TO THE FIRST
           addFirst(e1);
       }
       if (index1 >= listSizeA)
       {
//add to last
           addLast(e1);
       }
       else
       {
           Node<E> crNode = hNode;
           for (int k1 = 1; k1 < index1; k1++)
           {
               crNode = crNode.next;
           }
           Node<E> t = crNode.next;
           crNode.next = new Node<E>(e1);
           (crNode.next).next = t;
           listSizeA++;
          
           t.previous = crNode.next;
           crNode.next.previous = crNode;
       }
   }
//REMOVE FIRAT NODEFROM THE LIST
   public E removeFirst()
   {
       if (listSizeA == 0)
       {
           return null;
       }
       else
       {
           Node<E> t = hNode;
           hNode = hNode.next;
           listSizeA--;
           if (hNode == null)
           {
               tNode = null;
           }
           return t.element;
       }
   }
//REMOVELAST NODE FROM THE LIST
   public E removeLast()
   {
       if (listSizeA == 0)
       {
           return null;
       }
       if (listSizeA == 1)
       {
           Node<E> temp = hNode;
           hNode = tNode = null;
           listSizeA = 0;
           return temp.element;
       }
       else
       {
           Node<E> crNode = hNode;

           for (int k1 = 0; k1 < listSizeA - 2; k1++)
           {
               crNode = crNode.next;
           }

       Node<E> temp = tNode;
       tNode = crNode;
       tNode.next = null;
       listSizeA--;
       return temp.element;
       }
   }
//REMOVE THE NODE AT THE GIVEN INDEX
   public E remove(int index1)
   {
   //CHECK FOR INDEX VALIDITY
       if (index1 < 0 || index1 >= listSizeA)
       {
           return null;
       }
       if (index1 == 0)
       {
//INDEX=0 TELLS THAT WE NEED TO REMOVE FIRST NODE
           return removeFirst();
       }
       if (index1 == listSizeA - 1)
       {
//INDEX=listSizeA - 1 TELLS THAT WE NEED TO REMOVE LAST NODE
           return removeLast();
       }
       else
       {
           Node<E> previous = hNode;
           for (int k1 = 1; k1 < index1; k1++)
           {
               previous = previous.next;
           }

       Node<E> crNode = previous.next;
       previous.next = crNode.next;
       crNode.next.previous = previous;
       listSizeA--;
       return crNode.element;
       }
   }

   @Override
   public String toString()
   {
//CREATE STRING FOR LIST ELEMENTS THROUGH StringBuilder
       StringBuilder rs = new StringBuilder("[");

       Node<E> crNode = hNode;
       for (int k1 = 0; k1 < listSizeA; k1++)
       {
           rs.append(crNode.element);
           crNode = crNode.next;
           if (crNode != null)
           {
               rs.append(", ");
           }
           else
           {
               rs.append("]");
           }
       }

       return rs.toString();
   }
//SET HEAD AND TAIL TO NULL
   public void clear()
   {
       hNode = tNode = null;
   }
//RETURN TRUE IF LIST CONTAINS THE GIVEN OBJECT e
   public boolean contains(Object e1)
   {
       Node<E> crNode = hNode;
       while(crNode!=null)
       {
           if(e1.equals(crNode.element))
               return true;
           crNode=crNode.next;
       }  
       return false;
   }
//RETURN ELEMENT AT THE GIVEN INDEX
   public E get(int index1)
   {
       Node<E> crNode = hNode;
       if(index1>listSizeA)
           return null;
       for (int k1 = 0; k1 < index1; k1++)
       {
           crNode=crNode.next;
       }
       return crNode.element;
   }
//RETURN THE INDEXOF THE ELEMENT IN THE LIST
   public int indexOf(Object e)
   {
       Node<E> crNode = hNode;
       int indE=0;
       while(crNode!=null)
       {
           if(crNode.element.equals(e))
               return indE;
           crNode=crNode.next;
           indE++;
       }
       return indE;
   }
//RETURN THE LAST INDEX OF THE ELEMENT IN THE LIST
   public int lastIndexOf(Object e1)
   {
       Node<E> crNode = tNode;
       int indE=listSizeA-1;
      
       while(crNode!=null && (e1.equals(crNode.element)))
       {
           crNode=crNode.previous;
           indE--;
       }
       if(crNode==null)
       {
           return -1;
       }
       return indE;
   }
//SET THE NODE WITH THE GIVEN ELEMENT AT SPECIFIES INDEX
   public E set(int index1, E e1)
   {
//CHECK FOR INDEX VALIDITY
       if(index1>listSizeA )
           return null;
       Node<E> crNode = hNode;
       while(index1>0)
       {
           crNode=crNode.next;
           index1--;
       }
       E t1=crNode.element;
       crNode.element=e1;
       return t1;      
   }
//RETURN ITERATOR
   public java.util.ListIterator<E> iterator()
   {
       return new twoWayList_Iterator<E>();
   }

//ITERATOR CLASS FOR 2 WAYLIST
   private class twoWayList_Iterator<E> implements java.util.ListIterator<E>
   {
       private Node<E> crNode = (Node<E>)hNode;
       int indE = 0;
      
       public twoWayList_Iterator()
       {
       }
  
       public twoWayList_Iterator(int index1)
       {
//CHECKING INDEX VALIDITY
           if (index1 < 0 || index1 > listSizeA)
               throw new IndexOutOfBoundsException("Index: " + index1 + ", Size: "
                       + listSizeA);
           for (int k = 0; k < index1; k++)
               crNode = crNode.next;
       }
  
       public boolean hasNext()
       {
//RETURN TRUE IF crNode!=NULL
           return (crNode != null);
       }

       public E next()
       {
//RETURN NEXT ELEMENT
           E e1 = crNode.element;
           crNode = crNode.next;
           indE++;
           return e1;
       }

       public void remove()
       {
//REMOVE AN ELEMENT
           Node<E> t1=crNode.previous;
           Node<E> t2=crNode.next;
           t1.next=t2;
           t2.previous=t1;
           crNode=t1;
           indE--;          
       }

       public void add(E e1)
       {
//ADD ELEMENT TO THE LIST
           Node<E> t1=crNode.previous;
           Node<E> t2=new Node(e1);
           Node<E> t3=crNode;
           t1.next=t2;
           t2.next=t3;
           t3.previous=t2;
           t2.previous=t1;
           indE++;

       }

       public boolean hasPrevious()
       {
//RETURN TRUE
           return crNode != hNode;
       }

       public int nextIndex()
       {
//RERTURN THE NEXT INDEX
           return indE;
          
       }

       public E previous()
       {
//RETURN PREVIOUS ELEMENT
           E e1 = crNode.element;
           crNode = crNode.previous;
           return e1;
       }

       public int previousIndex()
       {
//RETURN THE PREVIOUS INDEX
           return indE-1;
       }

       @Override
       public void set(E e)
       {
           crNode.element = e;
       }
   }

   public class Node<E>
   {
       E element;
       Node<E> next;
       Node<E> previous;

       public Node(E e)
       {
//set ELEMENT WITH e
           element = e;
       }
   }

   public int size()
   {
//RETURN THE SIZE OF THE LIST
       return listSizeA;
   }

   public ListIterator<E> listIterator(int index1)
   {
//RETURN THE ITERATOR STARTING AT THE SPECIFIED INDEX
       return new twoWayList_Iterator<E>(index1);
   }
   }