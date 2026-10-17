//Today is Monday
import java.util.Scanner;
public class NumberCount{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    String var = sc.nextLine();
    int counter = 0;
    for (int i = 0; i<var.length(); i++){
      int ascii = (int)var.charAt(i);
      if (ascii>=48 && ascii<=57){
        counter++;
        System.out.println(var.charAt(i));
      }
    }
    System.out.println("Total Number Count:"+counter);
  }
}
    