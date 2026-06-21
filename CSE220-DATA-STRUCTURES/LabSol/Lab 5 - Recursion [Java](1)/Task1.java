import java.util.Scanner;

public class Task1 {

    // Task 1A: Print numbers from 1 to 10 using a loop
    public static void task1A() {
        // TODO: Implement this using a loop
        int i=1;
        while(i<11) System.out.print(i+++" ");
        System.out.println();
    }

    // Task 1B: Print numbers from 1 to 10 using recursion
    public static void task1B_recursive(int i) {
        // TODO: Implement this recursively
        if(i>10){
            System.out.println();
            return;
        }
        System.out.print(i+" ");
        task1B_recursive(++i);
    }

    // Task 1C: Print numbers from 1 to n using a loop
    public static void task1C(int n) {
        // TODO: Implement this using a loop
        int i=1;
        while(i<=n) System.out.print(i+++" ");
        System.out.println();
    }

    // Task 1D: Print numbers from 1 to n using recursion
    public static void task1D_recursive(int i, int n) {
        // TODO: Implement this recursively
        if(i>n){
            System.out.println();
            return;
        }
        System.out.print(i+" ");
        task1D_recursive(++i, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Driver code for testing Task 1 methods
        // Write on your own
        System.out.println("Printing from 1 to 10 using loop: ");
        task1A();

        System.out.println("\nPrinting from 1 to 10 using recursion: ");
        task1B_recursive(1);

        System.out.print("\nN:");
        int N=sc.nextInt();
        System.out.println("\nPrinting from 1 to N using loop: ");
        task1C(N);

        System.out.println("\nPrinting from 1 to N using recursion: ");
        task1D_recursive(1, N);

        sc.close();
    }
}
