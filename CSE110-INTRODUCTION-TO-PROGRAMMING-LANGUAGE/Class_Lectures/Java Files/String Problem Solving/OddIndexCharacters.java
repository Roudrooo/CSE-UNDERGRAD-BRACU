//Today is Monday
import java.util.Scanner;
public class OddIndexCharacters{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    String var = sc.nextLine();
    String out = "";
    for (int i = 1; i<var.length(); i = i+2){
      out=out+var.charAt(i);
    }
    System.out.println(out);
  }
}
    