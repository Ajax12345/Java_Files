import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;


public class Practice_Java//name of class needs to be the same as filename
{
  public static List<String>stop_words() throws FileNotFoundException
  {
    File input = new File("/Users/davidpetullo/nltk_data/corpora/stopwords/english");
    Scanner inputfile = new Scanner(input);
    List<String>words = new ArrayList<String>();
    while (inputfile.hasNext())
    {
      String the_line = inputfile.nextLine();
      String new_line = the_line.toLowerCase();
      words.add(new_line);
    }
    return words;
  }

  public static List<String>filtered_query(String query, List<String>stops)
  {
    List<String>to_return = new ArrayList<String>();
    String [] split_query = query.split(" ");
    for (String i: split_query)
    {
      String the_new_word = i.toLowerCase();
      if (!stops.contains(the_new_word))
      {
        to_return.add(the_new_word);
      }
    }
    return to_return;
  }

  public static void main(String[] args) throws FileNotFoundException
  {
    String query = "Military officials say the attackers are surrounded inside the compound";
    List<String>files = Arrays.asList("/Users/davidpetullo/txtfolders/doc1.txt", "/Users/davidpetullo/txtfolders/doc2.txt", "/Users/davidpetullo/txtfolders/doc3.txt", "/Users/davidpetullo/txtfolders/doc4.txt", "/Users/davidpetullo/txtfolders/doc5.txt");
    List<String>stopwords = stop_words();
    List<String>final_query = filtered_query(query, stopwords);
    List<String>second_final_query = new ArrayList<String>();
    /*
    for (String i: final_query)
    {
      String final_string = i.toLowerCase();
    }
    */
    for (String i: files)
    {
      File input = new File(i);
      Scanner inputfile = new Scanner(input);
      List<String>all_words = new ArrayList<String>();
      while (inputfile.hasNext())
      {
        String the_line = inputfile.nextLine();
        String [] words = the_line.split(" ");

        for (String b: words)
        {
          String new_string = b.toLowerCase();
          //System.out.println(new_string);
          if (!stopwords.contains(new_string))
          {
            all_words.add(new_string);
          }

        }
      }
      boolean flag =false;
      for (String c: final_query)
      {

        if (all_words.contains(c))
        {
          flag = true;
        }
        else
        {
          flag = false;
          break;
        }
      }
      String decision = (flag)?"found":"not found";

      System.out.println("File: "+i);
      System.out.println(decision);

    }

  }




}
