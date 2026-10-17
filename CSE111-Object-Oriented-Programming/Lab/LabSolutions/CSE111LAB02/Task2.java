public class Task2{
  public static void main(String[] args){
    for(int i=2;i<=20;i+=2){
      System.out.print(i+", ");
    }
    for(int i=18;i>=2;i-=2){
      if(i==2){
        System.out.print(i);
      }else{
      System.out.print(i+", ");
      }
    }
    System.out.println();
  }
}