import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Practice_Java//name of class needs to be the same as filename
{
  public static void main(String[] args) throws FileNotFoundException
  {
    HashMap<Integer, String>map = new HashMap<Integer, String>();
    List<Integer>numbers = new ArrayList<Integer>();
    List<String>letters = new ArrayList<String>();
    File input = new File("data.txt");
    Scanner inputfile = new Scanner(input);

    while (inputfile.hasNext())
    {
      String the_line = inputfile.nextLine();

      System.out.println(the_line);

      String [] data = the_line.split("-");


      int new_number = Integer.parseInt(data[0]);

      numbers.add(new_number);
      letters.add(data[1]);

    }

    for (int i = 0; i<numbers.size(); i++)
    {
      map.put(numbers.get(i), letters.get(i));
    }

    Collections.sort(numbers);

    for (int i: numbers)
    {
      System.out.println(i);
    }

    for (int i:numbers)
    {
      System.out.println(i+"-"+map.get(i));
    }


}

}
