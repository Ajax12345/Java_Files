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
    HashMap<Character, Character> converter = new HashMap<Character, Character>();

    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    int rotation = 8;
    String new_alphabet = alphabet.substring(8)+ alphabet.substring(0, 8);

    for (int i = 0; i < alphabet.length(); i++)
    {
      converter.put(alphabet.charAt(i), new_alphabet.charAt(i));
    }
    String message = "attackatdawntomorrow";

    for (int i = 0; i < message.length(); i++)
    {
      System.out.print(converter.get(message.charAt(i)));
    }
  }



}
