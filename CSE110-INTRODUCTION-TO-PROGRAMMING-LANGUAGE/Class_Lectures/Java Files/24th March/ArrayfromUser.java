import java.util.Scanner;
import java.util.Arrays;
class ArrayfromUser {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    System.out.print("Please enter the length of the Array: ");
    int length = sc.nextInt();
    int [] newArray = new int [length];
    for (int i = 0; i<length; i++){
      System.out.print("Enter array element: ");
      int in = sc.nextInt();
      newArray[i] = in;
    }
    System.out.println(Arrays.toString(newArray));
    for (int i = 0; i< newArray.length; i++){
      System.out.println(newArray[i]);
    }
  }
}
