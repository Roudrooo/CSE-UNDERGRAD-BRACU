import java.util.Scanner;
public class Task02{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    while (true){
      System.out.println("Enter a number: ");
      int num = sc.nextInt();
      if (num>0){
        System.out.println(num+" ^ 2 = "+(num*num));
      }
      else if (num<0){
        break;
      }
    }
  }
}