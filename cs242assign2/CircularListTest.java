import static org.junit.Assert.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CircularListTest {
	Scanner inFile1 = null;  // needed to keep the compiler happy
    Scanner inFile2 = null;
    Scanner in = new Scanner (System.in);
    Leader s1, s2, winner;
    int index;
    CircularList<Leader> group;
    List<Leader> list1, list2;

	@Before
	public void setUp() throws Exception {
		inFile1 = new Scanner (new FileReader("PresidentsAndVicePresidents.txt"));
		inFile2 = new Scanner (new FileReader("PrimeMinisters.txt"));
		list1 = new LinkedList<Leader>();

	    while (inFile1.hasNextLine() ) {
			  String aLine = inFile1.nextLine();
			  String lName = aLine.substring(0, 13).trim();
			  String fName = aLine.substring(14);
			  list1.add(new Leader(fName, lName) );
	    }

	    // now let us create another List of Leader objects
		list2 = new ArrayList<Leader>();

		while (inFile2.hasNextLine() ) {
		  	 String aLine = inFile2.nextLine();
		     String lName = aLine.substring(0, 13).trim();
		     String fName = aLine.substring(14).trim();
		  	 list2.add(new Leader(fName, lName) );
	    }

	    // now create a circle to play Josephus game
	    group = new CircularList <Leader> (list1);
	}

	@Test
	public void test1_IndexOf() {
		s1 = new Leader("David", "Ben-Gurion");
		assertEquals(77, group.indexOf(s1));
	}

	@Test
	public void test2_IndexOf() {
		s1 = new Leader("Charles", "Fairbanks");
		assertEquals(24, group.indexOf(s1));
	}

	@Test
	public void testadd() {
		s1 = new Leader("Stephen", "Harper");
		group.add(s1);
	    assertEquals(s1, group.get(group.size() - 1));
	}

	@Test
	public void testaddWithIndex() {
		int count = group.size();
		s1 = new Leader("Kim", "Campbell");
		group.add(15, s1);
		s2 = new Leader("John", "Turner");
		group.add(12, s2);
		assertEquals(count + 2, group.size());
		assertEquals(s1, group.get(16));
	}

	@Test
	public void testSet() {
		s1 = new Leader("Joe", "Clark");
		group.add(15, s1);
		s2 = new Leader("Lester", "Pearson");
		group.add(12, s2);
		group.set(16, s2);
		group.set(12, s1);
		assertEquals(s2, group.get(16));
		assertEquals(s1, group.get(12));
	}

	@Test
	public void test1_Remove() {
		int count = group.size();
		s1 = new Leader("James", "Madison");
		group.remove(s1);
		assertTrue(group.indexOf(s1) < 0);
		assertEquals(count - 1, group.size());
	}

	@Test
	public void test2_Remove() {
		int count = group.size();
		s1 = group.get(24);
		group.remove(24);
		assertTrue(group.indexOf(s1) < 0);
		assertEquals(count - 1, group.size());
	}

	@Test
	public void test3_Remove() {
		int count = group.size();
		s1 = group.get(0);
		group.remove(0);
		assertTrue(group.indexOf(s1) < 0);
		assertEquals(count - 1, group.size());
	}

	@Test
	public void test4_Remove() {
		int count = group.size();
		s1 = group.get(count-1);
		group.remove(count -1);
		assertTrue(group.indexOf(s1) < 0);
		assertEquals(count - 1, group.size());
	}

	@Test
	public void test1_startPositionr() {
		s1 = new Leader("Richard", "Nixon");
		group.setStartPosition(group.indexOf(s1));
		assertEquals(0, group.indexOf(s1));
	}

	@Test
	public void test1_getWinner() {
		s1 = new Leader("James", "Monroe");
		s2 = new Leader("Henry", "Wilson");
		group.setStartPosition(group.indexOf(s1));
		assertEquals(s2, group.getWinner());
		assertEquals(1, group.size());
	}

	@Test
	public void test2_getWinner() {
		group.add(new Leader("Narendra", "Modi"));
	    group.add(10, new Leader ("Manmohan", "Singh"));
	    group.add(15, new Leader ("Atal Bihari", "Vajpayee"));
	    Leader s1 = group.set(12, new Leader("I.K.", "Gujral"));
	    assertEquals(new Leader("William", "King"), s1);
	    group.add(22, new Leader("H.D. Deva", "Gowda"));
	    s1 = group.remove(8);
	    group.add(17, s1);
	    group.remove(new Leader("Gerald", "Ford"));
	    s1 = new Leader("James", "Sherman");
		s2 = new Leader("Yitzhak", "Shamir");
		assertEquals(28, group.indexOf(s1));
		group.setStartPosition(group.indexOf(s1));
		assertEquals(0, group.indexOf(s1));
		assertEquals(93, group.size());
		assertEquals(s2, group.getWinner());
		assertEquals(1, group.size());
	}

	@Test
	public void test3_getWinner() {
		group = new CircularList <Leader> ();
	    group.add(0, new Leader("Martin", "Van Buren"));
	    group.addAll(list1);
	    group.addAll(list2);
	    group.remove(new Leader("Golda", "Meir"));
	    s1 = group.get(21);
	    group.setStartPosition(group.indexOf(s1));
	    assertEquals(0, group.indexOf(s1));
	    s2 = group.get(92);  // note that index starts at 0
	    assertEquals(s2, group.getWinner());
	    assertEquals(1, group.size());
	}

	@Test
	public void test4_getWinner() {
		group = new CircularList <Leader> ();
		group.addAll(list1);
	    s1 = group.get(38);
	    assertEquals(s1, new Leader("Gerald", "Ford"));
	    group.setStartPosition(group.indexOf(s1));
	    assertEquals(0, group.indexOf(s1));
	    s2 = group.get(52);
	    assertEquals(s2, group.getWinner());
	    assertEquals(1, group.size());
	}

	@Test (expected=IndexOutOfBoundsException.class)
	public void testGetWithException_1() {
		group.get(group.size());
	}

	@Test (expected=IndexOutOfBoundsException.class)
	public void testGetWithException_2() {
		group.get(-1);
	}

	@Test (expected=IndexOutOfBoundsException.class)
	public void testAddWithException_1() {
		group.add(group.size() + 1, new Leader("John", "Doe"));
	}

	@Test (expected=IndexOutOfBoundsException.class)
	public void testAddWithException_2() {
		group.add(-1, new Leader("John", "Doe"));
	}

	@Test (expected=IndexOutOfBoundsException.class)
	public void testRemoveWithException_1() {
		group.remove(group.size() + 1);
	}

	@Test (expected=IndexOutOfBoundsException.class)
	public void testRemoveWithException_2() {
		group.remove(-1);
	}

	@After
	public void tearDown()  {
		inFile1.close();
		inFile2.close();
	}
}
