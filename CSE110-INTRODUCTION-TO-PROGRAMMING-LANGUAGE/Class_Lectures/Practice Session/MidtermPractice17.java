import java.util.Scanner;
class MidtermPractice17{
  public static void main (String [] args){
    Scanner sc = new Scanner (System.in);
    int c = 1;
    int z = 1;
//    c=c++ + c-- + z++ + z-- + ++c;
    System.out.println(c);
    System.out.println(z);
    c++;
    System.out.println(c);
    System.out.println(z++);
    System.out.println(z);
    ++z;
    System.out.println(z);
    System.out.println(++c);
    c=c++ + c-- + z++ + z-- + ++c;//3+4+3+4+4
    System.out.println(c);
    System.out.println(z);
  }
}