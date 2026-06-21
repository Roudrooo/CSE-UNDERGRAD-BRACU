import java.util.Scanner;
public class Task4{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    int sum=0,min=0,max=0,count=0;
    for(int i=1;i<=10;i++){
      System.out.printf("Number %d: ",i);
      int in=input.nextInt();
      if(in%2!=0&&in>0){
        sum+=in;
        if(count==0){
          max=in;
          min=in;
        }
        if(in>max){
          max=in;
        }
        if(in<min){
          min=in;
        }
        count++;
      }
    }
    if(count==0){
      System.out.println("No odd positive numbers found");
    }else{
      double avg=(double)sum/count;
      System.out.println("Sum = "+sum+"\nMinimum = "+min+"\nMaximum = "+max+"\nAverage = "+avg);
    }
    input.close();
  }
}