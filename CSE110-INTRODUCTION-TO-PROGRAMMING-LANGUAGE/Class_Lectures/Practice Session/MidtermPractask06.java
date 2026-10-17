import java.util.Scanner;
class MidtermPractask06{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    double sum = 0.0;
    for (int i =1; i<=n; i++){
      if (i%4==0){
        sum = sum - (1.0/i);
      }
      else{
        sum = sum + (1.0/i);
      }
    }
    System.out.printf("y = %.4f",sum);
  }
}
    