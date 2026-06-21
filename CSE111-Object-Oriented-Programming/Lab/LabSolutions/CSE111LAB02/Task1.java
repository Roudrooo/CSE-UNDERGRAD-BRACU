public class Task1{
  public static void main(String[] args){
    //a
    int i=2;
    while(i<=50){
      if(i==50){
        System.out.print(i);
      }else{
      System.out.print(i+", ");
      }
      i+=4;
    }
    System.out.println();
    
    //b
    int j=1,x=2;
    while(j<=120){
      if(j==120){
        System.out.print(j);
      }else{
      System.out.print(j+", ");
      }
      j+=x++;
    }
    System.out.println();
  }
}