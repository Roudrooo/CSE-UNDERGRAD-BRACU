import java.util.Scanner;
public class LoopTask06{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    System.out.print("Enter an operator:");
    String s1 = sc.nextLine();
    if (s1.equals("+")){
      System.out.println("Found +");
    }
  }
}