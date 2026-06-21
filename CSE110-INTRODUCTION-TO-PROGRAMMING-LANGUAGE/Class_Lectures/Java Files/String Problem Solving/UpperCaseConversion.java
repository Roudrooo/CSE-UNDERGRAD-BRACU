//Today is 231 Monday
//today is 231 monday
import java.util.Scanner;
public class UpperCaseConversion{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    String var = sc.nextLine();
    String out = "";
    for (int i = 0; i<var.length(); i++){
      int ascii =(int)var.charAt(i);
      if (ascii>=97 && ascii<=122){
        int newascii = ascii-32;
        out = out + (char)newascii;
      }
      else{
      out=out+var.charAt(i);
      }
    }
    System.out.println(out);
  }
}
    