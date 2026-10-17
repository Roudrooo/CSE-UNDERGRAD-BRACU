import java.util.Scanner;
class MidtermPractask15{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    double max = Double.NEGATIVE_INFINITY;
    double min = Double.POSITIVE_INFINITY;
    int sum = 0;
    int count = 0;
    while (true){ 
      System.out.print("Enter another Number:");
      int n = sc.nextInt();
      if (n==0){break;}
      if ((n%2==0) && (n>0)){
        sum = sum + n;
        count++;
      }
      if ((n>max) && (n%2==0) && (n>0)){
        max = n;
      }
      if ((n<min) && (n%2==0) && (n>0)){
        min = n;
      }
    }
    System.out.println("Max: "+(int)max);
    System.out.println("Min: "+(int)min);
    System.out.println("Average: "+(sum/count));
  }
}