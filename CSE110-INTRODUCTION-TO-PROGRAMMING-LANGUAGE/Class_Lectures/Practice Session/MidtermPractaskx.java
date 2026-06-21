import java.util.Scanner;
class MidtermPractaskx{
  public static void main (String [] args){
    boolean flag = false;
    int num = 11;
    while (true){
      if (num > 10){
        num -=5;
      }
      else {
        num-=2;  
        }
      if (flag){
        break;
      }
      if (num<0){
        flag = true;
      }
    }
    System.out.println(flag);
  }
}