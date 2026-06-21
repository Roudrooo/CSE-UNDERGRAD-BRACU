import java.util.Scanner;
public class ReverseStart{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    String var = sc.nextLine();
    String out = "";
    for (int i = var.length()-1; i>=0; i--){
      out=out+var.charAt(i);
    }
    System.out.println(out);
  }
}
    