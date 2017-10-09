import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class CircListTest{
  public static Scanner inFile1 = null;  // needed to keep the compiler happy
  public static Scanner inFile2 = null;
  public static Scanner in = new Scanner (System.in);
  public static Leader s1, s2, winner;
  public static int index;
  public static CircularList<Leader> group;
  public static List<Leader> list1, list2;
    public static void setUp() throws FileNotFoundException
    {
      inFile1 = new Scanner (new FileReader("PresidentsAndVicePresidents.txt"));
          inFile2 = new Scanner (new FileReader("PrimeMinisters.txt"));
          list1 = new LinkedList<Leader>();

      while (inFile1.hasNextLine())
      {

        String aLine = inFile1.nextLine();
        String lName = aLine.substring(0, 13).trim();
        String fName = aLine.substring(14);
        list1.add(new Leader(fName, lName));
      }



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
    public static void test1_IndexOf() {
        System.out.println("in indexOf");
        s1 = new Leader("David", "Ben-Gurion");

        try
        {
          if (group.indexOf(s1) == 77)
          {

            System.out.println("indexOf works fine!!");

          }
          else
          {
            System.out.println(group.indexOf(s1));
            System.out.println("indexOf ran, but with incorrect output");
          }

        }
        catch(Exception e)
        {
          System.out.println("indexOf failed with error "+e);
        }

    }
    public static void testadd() {

        s1 = new Leader("Stephen", "Harper");
        try
        {
          group.add(s1);
          if (group.get(group.size()-1) == s1)
          {
            System.out.println("add works fine!");
          }
          else
          {
            System.out.println("add ran, but with wrong results");
          }

        }
        catch (Exception e)
        {
          System.out.println("add failed with exception "+e);
        }


    }
    public static void testSet() {
        s1 = new Leader("Joe", "Clark");
        try
        {
          group.add(15, s1);
          s2 = new Leader("Lester", "Pearson");
          group.add(12, s2);
          group.set(16, s2);
          group.set(12, s1);
          if (group.get(16) == s2 && group.get(12) == s1)
          {
            System.out.println("Set worked fine!");
          }
          else
          {
            System.out.println("Set ran, but with incorrect results");
          }


        }
        catch (Exception e)
        {
          System.out.println("Set failed with error "+e);
        }


    }
    public static void test1_Remove() {
        try
        {
          int count = group.size();
          s1 = new Leader("James", "Madison");
          group.remove(s1);
          if (group.indexOf(s1) < 0 && group.size() == count - 1)
          {
            System.out.println("remove ran successfully");
          }
          else
          {
            System.out.println("remove ran, but with incorrect results");
          }
        }
        catch (Exception e)
        {
          System.out.println("remove ran incorrectly");
        }

    }
    public static void tearDown()  {
        inFile1.close();
        inFile2.close();
    }


    public static void main(String args[]) throws FileNotFoundException
    {
      setUp();
      testadd();
      tearDown();

    }


}
