import java.util.Scanner;
public class Task01{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    int num = sc.nextInt();
    for (int k = 1; k <= num; k = k + 1){
      for (int i = 1; i<=k; i=i+1){
        if (k%i == 0){
          System.out.print(i+" ");
        }   
      }
      System.out.println();
    }
  }
}