package Collections;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        
    
    LinkedList<Integer> ll=new LinkedList<Integer>();
        for(int i=1;i<5;i++)
        {
            ll.add(i+10);
        }
        
        
        ll.addFirst(0);         
        ll.addLast(5);
        System.out.println(ll);
        System.out.println(ll.get(2));
        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.peek());//retrieves head, doesnt remove
        System.out.println(ll.remove());//retrieves and removes head; returns head
        
        
        System.out.println(ll);
        Iterator<Integer> itr=ll.descendingIterator();
        //prints in reverse order
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        
        
        ListIterator<Integer> litr=ll.listIterator(3);
         System.out.println("Printing before index 3");
        while(litr.hasPrevious())
                     System.out.println(litr.previous());
       
        System.out.println("Print using List Iterator");
        while(litr.hasNext())
             System.out.println(litr.next());
    
        Collections.reverse(ll);
    }
}
