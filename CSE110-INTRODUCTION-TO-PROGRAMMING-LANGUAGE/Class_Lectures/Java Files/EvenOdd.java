import java.util.Scanner;
public class EvenOdd{
  public static void main (String [] args){
    System.out.print("Please enter a number: ");
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    if (num%2 == 0){
      if (num%10 == 0){
        System.out.println(num);
      }
    }
    else{
      if (num%5 == 0){
        System.out.println(num*2);
      }
    }
  }
}