import java.util.Scanner;
public class grade_checker{
  public static void main (String [] args){
    System.out.print("Please enter your marks: ");
    Scanner sc = new Scanner(System.in);
    double marks = sc.nextDouble();
//    System.out.println(marks);
    if (marks>=90 && marks<=100){
      System.out.println("A+");
    }
    else if (marks>=80 && marks<=90){
      System.out.println("A");
    }
    else if (marks>=70 && marks<=79){
      System.out.println("B");
    }
    else if (marks>=60 && marks<=69){
      System.out.println("C");
    }
    else if (marks>=50 && marks<=59){
      System.out.println("D");
    }
    else if (marks>=0 && marks<=49){
      System.out.println("F");
    }
  }
}
    