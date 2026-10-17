import java.util.Scanner;
public class Calc {
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    System.out.print("Enter the first Number: ");
    int n1 = sc.nextInt();
    System.out.print("Enter the second Number: ");
    int n2 = sc.nextInt();
    System.out.println("First Number: "+n1+" Second Number: "+n2);
    int sum = n1+n2;
    System.out.println("Summation: "+sum);
    int mul = n1*n2;
    System.out.println("Multiplication: "+mul);
  }
}
