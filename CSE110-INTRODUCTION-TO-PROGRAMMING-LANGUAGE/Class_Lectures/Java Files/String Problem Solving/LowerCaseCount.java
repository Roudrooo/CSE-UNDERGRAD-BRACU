//Today is Monday
import java.util.Scanner;
public class LowerCaseCount{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    String var = sc.nextLine();
    int counter = 0;
    for (int i = 0; i<var.length(); i++){
      int ascii = (int)var.charAt(i);
      if (ascii>=97 && ascii<=122){
        counter++;
//        System.out.println(var.charAt(i));
      }
    }
    System.out.println(counter);
  }
}
    