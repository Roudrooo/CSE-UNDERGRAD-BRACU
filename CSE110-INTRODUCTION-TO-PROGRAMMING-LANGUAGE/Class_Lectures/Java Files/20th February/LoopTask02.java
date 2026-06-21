public class LoopTask02{
  public static void main (String [] args){
    int i = 1;
    while (i <= 120){
      if (i%7 == 0){
        System.out.print(i+" ");
      }
      i = i + 1;
    }
  }
}