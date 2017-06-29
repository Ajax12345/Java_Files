import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;

public class Practice_Java//name of class needs to be the same as filename
{
  public static void main(String[] args) throws FileNotFoundException
  {


    String my_val = "James";
    int first = 234;
    double second = 424.232345;
    boolean flag = false;
    System.out.println("Hello World!"+my_val.charAt(2));

    System.out.println(first);
    System.out.println("_______________");

    System.out.println(my_val.toUpperCase().charAt(2));

    Scanner keyboard = new Scanner(System.in);
    int the_val;
    System.out.println("Enter your val: ");

    the_val = keyboard.nextInt();
    System.out.println("Your number was\n");
    System.out.println(the_val);
    //boolean flag;

    System.out.println("got to here");

    if (the_val > 4)
    {
      System.out.println("That works");
      flag = true;
    }
    else
    {
      System.out.println("It did not work");
    }
    if (flag)
    {
      System.out.println("It is indeed true");

    }



    String new_stuff;

    Scanner keyboard1 = new Scanner(System.in);

    new_stuff = keyboard1.nextLine();



    System.out.println(new_stuff.toLowerCase());


    try
    {
      PrintWriter output = new PrintWriter("javatextfile.txt");
      output.println("Hello world");
      output.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println(e.getMessage());
    }

    System.out.println("File created");
  



  }

}
//To run:
//javac Practice_Java.javac
//java Practice_Java
