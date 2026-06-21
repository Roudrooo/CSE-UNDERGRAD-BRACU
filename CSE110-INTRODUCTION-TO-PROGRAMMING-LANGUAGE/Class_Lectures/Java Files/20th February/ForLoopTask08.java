import java.util.Scanner;
public class ForLoopTask08{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    for (int i = 1; i <=5; i = i + 1){
      System.out.print("Enter a number:");
      int x = sc.nextInt();
      System.out.println(x);
    }
  }
}