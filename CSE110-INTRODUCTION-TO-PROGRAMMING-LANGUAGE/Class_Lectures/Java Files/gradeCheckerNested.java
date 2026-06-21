import java.util.Scanner;
public class gradeCheckerNested{
  public static void main (String [] args){
    System.out.print("Please enter your marks: ");
    Scanner sc = new Scanner(System.in);
    double marks = sc.nextDouble();
    if (marks>=0 && marks<=100){
      if (marks>=90){
        System.out.println("A+");
      }
      else if (marks>=80 && marks<=90){
        System.out.println("A");
      }
      else if (marks>=70 && marks<=80){
        System.out.println("B");
      }
      else if (marks>=60 && marks<=70){
        System.out.println("C");
      }
      else if (marks>=50 && marks<=60){
        System.out.println("D");
      }
      else{
        System.out.println("F");
      }
    } 
    else{
      System.out.println("Invalid Marks");
    }
  }
}   