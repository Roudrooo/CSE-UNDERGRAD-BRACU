import java.util.Scanner;
public class LoopTask08{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    int sum = 0;
    int i = 1;
    while (i <=5){
      System.out.print("Enter a number:");
      int x = sc.nextInt();
      sum = sum + x;
//      System.out.println(x);
      i = i + 1;
    }
    System.out.println(sum);
  }
}