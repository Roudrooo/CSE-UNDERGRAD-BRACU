import java.util.Scanner;
public class LoopTask05{
  public static void main (String [] args){
    System.out.println("Please enter a number: ");
    Scanner sc = new Scanner (System.in);
    int num = sc.nextInt();
    int i = 1;
    while (i<=10){
      int res = num * i;
      System.out.println(num+" x "+i+" = "+res);
      i = i + 1;
    }
  }
}