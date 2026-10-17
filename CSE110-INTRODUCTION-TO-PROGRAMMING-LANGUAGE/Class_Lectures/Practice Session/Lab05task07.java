import java.util.Scanner;
class Lab05task07{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    int start = sc.nextInt();
    int end = sc.nextInt();
    int div = sc.nextInt();
    for (int i = start; i<=end; i++){
      int num = i;
      int pro = 1; //30
      while (num!=0){
        int digit = num%10; //352%10=2, 35%10=5, 3%10=3
        pro = pro * digit;
        num = num/10; //352/10=35, 35/10=3, 3/10=0
      }
      if (pro%div==0){
        System.out.print(pro+" ");
      }
    }
  }
}