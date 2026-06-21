//Today is Monday
import java.util.Scanner;
public class DivisibleByFiveIndexCharacters{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    String var = sc.nextLine();
    String out = "";
    for (int i = 0; i<var.length(); i = i+5){
      out=out+var.charAt(i);
    }
    System.out.println(out);
  }
}
    