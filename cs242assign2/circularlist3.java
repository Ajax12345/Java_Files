/** Implementation of Josephus problem.  The Josephus problem
    is named aftr the historian Flavius Josephus.  For more
    information on this problem visit:
    http://en.wikipedia.org/wiki/Josephus_problem
  */
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.List;

public class CircularList <E> {
     private Node<E> head;
     private Node<E>tail;
     private int count;  // number of elements in the list

     // Complexity: O(1)
     /** Constructs an empty Josephus circle
       */

     public CircularList() {
		 head = null;
		 //tail = null;
		 count = 0;
     }

     // Complexity: O(n)
     /** Constructs an Josephus circle by adding the
         elements from a list
         @param list The List of items of type E
       */

     public CircularList(List<E> list) {
		 head = null;
		 for (int i = 0; i < list.size(); i++)
			 add(list.get(i));
     }

     // Complexity O(n)
     /** Inserts the specified element in the list at the
         last position
         @param dataItem the element to add
       */

     public void add(E dataItem) {
	     // To be completed by the student
       Node<E>headNode = new Node<E>(dataItem);
       if (count == 0)
       {
         head = headNode;
         head.previous = head;
         head.next = head;

       }
       else
       {
         headNode.next = head;
         headNode.previous = head.previous;
         head.previous.next = headNode;
         head.previous = headNode;


       }
       count ++;
     }

     // Complexity O(n)
     /** appends all the elements from the list
         to the Josephus circle.
         @param list the List of elements to add
       */

     public void addAll(List <E> list) {
	     for (int i = 0; i < list.size(); i++) {
	         add(list.get(i));
	     }
     }

     // Complexity O(n)
     /** returns a reference to the element at
	     position index
	     @param index The index of the element being sought
	     @return A reference to the element at position index
	     @throws IndexOutOfBoundsException if index is out of range
	   */
	 public E get(int index)  {
		 // To be completed by the student
     if (index < 0 || index >= count)
     {
       throw new IndexOutOfBoundsException();
     }
     Node<E>temp = head;
     for (int i = 0; i < index; i++)
     {
       temp = temp.next;
     }

     return temp.data;
    }

      /** Returns the index of the first occurrence of the specified element
        * in this list, or -1 if this list does not contain the element.
        * @param o the element to search for
        * @return the index of the first occurrence of the specified element in
        * this list, or -1 if this list does not contain the element
        */
      public int indexOf(Object o) {

        Node<E>temp = head;
        int counter = 0;
        for (int i = 0; i < count; i++)
        {
          if (temp.data.equals(o))
            return counter;
          temp = temp.next;
        }
        return -1;
	     }

     // Complexity O(n)
     /** Sets the element at position index to reference
         anEntry.
         @param index The position of the element that is to
         be set
         @param anEntry The new value at position index
         @return the element that was previously at position index
         @throws IndexOutOfBoundsException if index is out of range
       */
      public E set(int index, E anEntry) {
         if ((index < 0) || (index >= count)) throw new IndexOutOfBoundsException(Integer.toString(index));
		     Node<E>newNode = new Node<E>(anEntry);
         Node<E>temp = head;
         for (int i = 0; i < index; i++)
         {
           temp.next = temp;
         }

         E holder = temp.data;

         head.next = temp.next;
         head = newNode;
         count++;
         return holder;

     }

     // Complexity O(n)
     /** Inserts the specified element in the list at a
         given index
         @param index The position at which the new element
         is to be inserted
         @param anEntry The element to add
         @throws IndexOutOfBoundsException if index is out of range
       */
	 public void add(int index, E anEntry) {
		 Node<E>newNode = new Node<E>(anEntry);
     if (index < 0 || index >= count)
     {
       throw new IndexOutOfBoundsException();
     }


     if (head == null)
     {
       head = newNode;
       newNode.next = head;
     }
     else
     {
       Node<E>temp = head;
       for (int i = 0; i < index; i++)
       {
         temp.next = temp;

       }
       if (temp.next == head)
       {
         temp.next = newNode;
         newNode.next = head;
       }
       else
       {

         newNode.next = temp.next;
         temp.next = newNode;
       }
     }
     count++;

	 }

	 // Complexity O(n)
	 /** removes the element at position index
	     @param index The index of the element to be removed
	     @return The element that was removed
	     @throws IndexOutOfBoundsException if index is invalid
	   */
     /*
     */
	 public E remove(int index) {
	     if (index < 0 || index >= count)
       {
         throw new IndexOutOfBoundsException();
       }
	   E the_object = get(index);
	   remove(the_object);
	   count--;
	   return the_object;


     }

     // Complexity O(n)
     /** removes the item from the list if it is present
	     @param item item to be removed
	     @throws NoSuchElementException if the item is not found
	   */
  public void remove(E item) {
      Node<E>temp = head;
     for (int i = 0; i < count; i++)
     {
       if (temp.data.equals(item))
       {

        // head.next = head;
         //head.previous.previous.next = head.previous;
         //head.next = head;
         //head.next.previous = head.next;
         //head.previous.previous = head.next;
         temp.previous.next.next = temp.next.previous;

       }

        temp = temp.next;

     }
     throw new NoSuchElementException();
     /*
     while (head.next != null)
     {
       if (head.data.equals(item))
       {
         flag = true;
         break;
       }
       head.next = head;
       tail.next = head;
       counter--;
     }
     if (!flag)
     {
       throw new NoSuchElementException();
     }

     */
     }

     // Complexity O(n)
     /** sets the start position for the Josephus game
         @param index The starting position
         @throws IndexOutOfBoundsException if index is invalid
       */
     public void setStartPosition(int index) {
        if (index < 0)
        {
          throw new IndexOutOfBoundsException();
        }
		    for (int i = 0; i < index; i++)
        {
          head = head.next;
        }
     }

     /* This private utility method is used in startJosephus
        method.
        Complexity O(1)
      */
     private void removeAfter(Node<E> node) {
		 node.next = node.next.next;
		 node.next.previous = node;
		 count--;
     }

     /** simulates the Josephus game by killing every other person
         until the winner is the only one left.
         @return The survivor of the game
       */
     private E startJosephus() {
		 while (count > 1) {
			 removeAfter(head);
			 head = head.next;
	     }
	     return head.data;
     }

     /** returns the sole survivor of the Josephus game
         @return the sole survivor of the Josephus game
       */
     public E getWinner() {
		 return startJosephus();
     }

     /** Returns a list-iterator of the elements in this list
        (in proper sequence), starting at the beginning
        of the list.  Also provides methods to traverse
        the list in the reverse order.
      */
    public ListIterator <E> iterator() {
	   return new MyIterator();
    }

    /** @return The number of elements in the list
      */
    public int size() {
		return count;
    }

    // this is an inner class implementing the ListIterator
    // interface.
    // visit http://docs.oracle.com/javase/6/docs/api/java/util/ListIterator.html
    // for a complete list of methods in ListIterator
    // Your book uses the ListIterator methods to implement
    // a doubly linked list (pages 112- 120)
    // I am using only hasNext(), next(), previous() and hasPrevious()
    // methods here.
    private class MyIterator implements ListIterator <E> {
        private Node<E> forward = head;
	    private Node<E> backward = head;
	    private boolean firstTime = true;

	    /** checks if a current item E  is the last
	        in the collection
	      */
	    public boolean hasNext() {
	        return (forward != null);
	    }

	    /** returns the next item in the collection if
	       there is one.  If there is no more items
	       throws NoSuchElementException
	      */
	    public E next() {
		   if (forward == null) throw
		  	 	new NoSuchElementException();
		   else {
		  	   E item = forward.data;
		  	   forward = forward.next;
		  	   if (forward == head) forward = null;
		  	   return item;
		   }
	     }

	     /** checks if a current item is the first
		     in the collection
	       */
	     public boolean hasPrevious() {
		     return (backward != null);
	     }

	     /** returns the previous item in the collection if
		     there is one.  If there is no more items
		     throws NoSuchElementException
	       */
	     public E previous() {
		     if (backward == null) throw
		  	    new NoSuchElementException();
		     else {
		 	    if (firstTime) {
					backward = backward.previous;
					firstTime = false;
				 }
				E item = backward.data;
		 	    backward = backward.previous;
		 	    if (backward == head.previous) backward = null;
		 	    return item;
		     }
          }

	      /* this operation is not supported */
	      public void add(E obj) {
		        throw new UnsupportedOperationException();
	      }

	      /* this operation is not supported */
	      public void set(E obj) {
		        throw new UnsupportedOperationException();
	      }

	      /* this operation is not supported */
	      public int previousIndex() {
		      throw new UnsupportedOperationException();
	      }

	      /* this operation is not supported */
	      public int nextIndex() {
		      throw new UnsupportedOperationException();
	      }

	      /* this operation is not supported */
	      public void remove() {
		      throw new UnsupportedOperationException();
	      }
    }

    /* the keyword "static" in the class header indicates
       that the Node<E> class will not reference its outer
       class.  In the Java API documentation, static inner
       classes are also called nested classes.
       Generally, we want to keep the details of the Node
       class private.  Thus the qualifier "private" is applied
       to the class as well to the data fields and constructor.
       However, the data fields and methods of an inner class
       are visible anywhere within the enclosing class (also
       known as the "parent" class.
      */
    private static class Node <E> {
        private E data;
        private Node<E> next;
        private Node<E> previous;

       /** constructor Creates an empty node with both next and
           previous fields set to be null
           @param dataItem - item to be inserted
         */
       private Node(E dataItem) {
           data= dataItem;
           previous = next = null;
       }

       /** creates a new node that references another node
           @param dataItem The data stored
           @param previousNodeRef The node previous to this node
           @param nextNodeRef The node next to this node
         */
       private Node(E dataItem, Node<E> previousNodeRef, Node <E> nextNodeRef ) {
	       data = dataItem;
	       previous = previousNodeRef;
           next = nextNodeRef;
       }
    }
}
