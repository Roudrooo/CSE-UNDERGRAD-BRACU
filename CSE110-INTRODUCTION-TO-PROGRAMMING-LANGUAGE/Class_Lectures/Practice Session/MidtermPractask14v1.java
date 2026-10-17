import java.util.Scanner;
class MidtermPractask14v1{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    int limit = sc.nextInt();
    double max = Double.NEGATIVE_INFINITY;
    double min = Double.POSITIVE_INFINITY;
    int sum = 0;
    int count = 0;
    for (int i = 1; i<=limit; i++){ 
      System.out.print("Enter another Number:");
      int n = sc.nextInt();
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