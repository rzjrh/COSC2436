
public class TestDll
{
   public static void main(String[] args)
   {
       TwoWayLinkedList<Integer> twoWayList = new TwoWayLinkedList<Integer>();
       twoWayList.add(1,1);
       twoWayList.add(2,6);
       twoWayList.add(3,5);
       twoWayList.add(4,2);
       twoWayList.add(5,7);
       twoWayList.add(6,11);

       System.out.println("The linked list Forward: "+twoWayList);

       
       
       java.util.ListIterator<Integer> listIterator = twoWayList.iterator();
       listIterator.next();
       listIterator.next();
       listIterator.next();
       listIterator.next();
       listIterator.next();
       

	   System.out.print("The linked list Backward: ");
       while (listIterator.hasPrevious())
           System.out.print(listIterator.previous() + ", ");
   }
}