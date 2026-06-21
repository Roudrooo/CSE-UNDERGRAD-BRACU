import java.util.Scanner;
public class Task11{
  public static void main(String[] args){
    Scanner input=new Scanner(System.in);
    int n=input.nextInt();
    //a
    System.out.println("Square pattern");
    for(int i=1;i<=n;i++){
      for(int j=1;j<=n;j++){
        System.out.print("*");
      }
      System.out.println();
    }
    //b
    System.out.println("Triangle pattern");
    for(int i=1;i<=n;i++){
      for(int j=1;j<=i;j++){
        System.out.print("*");
      }
      System.out.println();
    }
    input.close();
  }
}