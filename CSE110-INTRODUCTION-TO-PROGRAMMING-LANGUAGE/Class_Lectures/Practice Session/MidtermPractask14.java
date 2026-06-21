import java.util.Scanner;
class MidtermPractask14{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    int limit = sc.nextInt();
    System.out.print("Enter the first Number:");
    int num = sc.nextInt();
    int max = num;
    int min = num;
    int sum = num;
    for (int i = 1; i<limit; i++){ 
      System.out.print("Enter another Number:");
      int n = sc.nextInt();
      sum = sum + n;
      if (n>max){
        max = n;
      }
      if (n<min){
        min = n;
      }
    }
    System.out.println("Max: "+max);
    System.out.println("Min: "+min);
    System.out.println("Average: "+(sum/limit));
  }
}