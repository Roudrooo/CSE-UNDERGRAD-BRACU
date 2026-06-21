import java.util.Scanner;
public class Task02v1{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    System.out.println("Enter a number: ");
    int num = sc.nextInt(); //Initial value or Initilalization
    while (num>0){ //Condition
      System.out.println(num+" ^ 2 = "+(num*num));
      System.out.println("Enter a number: ");
      num = sc.nextInt(); //step
    }
  }
}