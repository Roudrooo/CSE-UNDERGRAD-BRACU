import java.util.Scanner;
public class Task3{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    int sum=0,max=0,min=0;
    for(int i=1;i<=10;i++){
      System.out.printf("Number %d: ",i);
      int in=input.nextInt();
      if(i==1){
        max=in;
        min=in;
      }
      sum+=in;
      if(in>max){
        max=in;
      }
      if(in<min){
        min=in;
      }
    }
    double avg=sum/10d;
    System.out.printf("Sum = %d\nMinimum = %d\nMaximum = %d\nAverage = %.1f\n",sum,min,max,avg);
    input.close();
  }
}