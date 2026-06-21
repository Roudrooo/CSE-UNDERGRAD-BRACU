import java.util.Arrays;
class Array {
  public static void main(String[] args) {
    int [] array = new int [] {1,2,3,4,5};  // [1, 2, 3, 4]
    int [] array2 = {1,2,3,4,7,9};        // [1, 2, 3, 4, 7, 9]
    int [] array3 = new int [3];          // [0, 0, 0]
    array3[0] = 9;                        // [9, 0, 0]
    array3[1] = 5;                        // [9, 5, 0]
    array3[2] = 16;                       // [9, 5, 16]
    System.out.println(array[0]);
    System.out.println(Arrays.toString(array)); 
    System.out.println(Arrays.toString(array2)); 
    System.out.println(Arrays.toString(array3));
  }
}
