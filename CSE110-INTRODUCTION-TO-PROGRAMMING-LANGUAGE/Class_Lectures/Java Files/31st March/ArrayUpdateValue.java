import java.util.Arrays;
class ArrayUpdateValue {
  public static void main(String[] args) {
    int [] array1 = {1,2,3,4,7,9};
    System.out.println(Arrays.toString(array1));
    array1[0] = 100;
    System.out.println(Arrays.toString(array1));
    for (int i = 0; i<array1.length; i++){
      array1[i] = 31;
    }
    System.out.println(Arrays.toString(array1));
  }
}
