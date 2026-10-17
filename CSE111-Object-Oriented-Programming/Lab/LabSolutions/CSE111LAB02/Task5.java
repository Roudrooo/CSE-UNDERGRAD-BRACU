import java.util.Scanner;
public class Task5{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    int zc=0,sum=0,max=0,min=0,ic=0,fnc=0,i=1;
    boolean flag=false;
    while(true){
      System.out.printf("Number %d: ",i);
      i++;
      int in=input.nextInt();
      if(in!=0){
        sum+=in;
        ic++;
        if(fnc==0){ 
          max=in; 
          min=in;
        }
        if(in>max) max=in;
        if(in<min) min=in;
        fnc++;
        flag=true;
      }
      if(in==0) zc++;
      else zc=0;
      if(zc==3){
        break;
      }
    }
    
    if(flag){
      double avg=(double)sum/ic;
      System.out.println("Sum = "+sum+"\nMinimum = "+min+"\nMaximum = "+max+"\nAverage = "+avg);
    }else{
      System.out.println("No numbers found");
    }
    input.close();
  }
}