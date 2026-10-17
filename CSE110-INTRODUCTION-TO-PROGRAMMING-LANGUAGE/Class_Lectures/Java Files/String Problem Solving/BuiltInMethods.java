import java.util.Scanner;
public class BuiltInMethods{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    String var = sc.nextLine();
    String lowercase = var.toLowerCase();
    System.out.println(lowercase);
    String uppercase = var.toUpperCase();
    System.out.println(uppercase);
  }
}
    