import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapTester{
    public static void main(String[] args) {
        Random rand=new Random();

        //FOR MINHEAP
        MinHeap minHeap=new MinHeap(15);
        for(int i=1;i<=10;i++){
            minHeap.insert(rand.nextInt(100));
        }
        System.out.println("MIN HEAP:");
        minHeap.printHeap();

        System.out.println("Inserting a value.");
        minHeap.insert(26);
        System.out.println("MIN HEAP:");
        minHeap.printHeap();

        System.out.println("Deleting a value");
        minHeap.delete(26);
        System.out.println("MIN HEAP:");
        minHeap.printHeap();

        System.out.println("Extracting minimum value which is: "+minHeap.extractMin());

        System.out.println("SORTED MIN HEAP");
        minHeap.printSorted();

        System.out.println("\n\n\n");

        //FOR MAXHEAP
        MaxHeap maxHeap=new MaxHeap(15);
        for(int i=1;i<=10;i++){
            maxHeap.insert(rand.nextInt(100));
        }
        System.out.println("MAX HEAP:");
        maxHeap.printHeap();

        System.out.println("Inserting a value.");
        maxHeap.insert(26);
        System.out.println("MAX HEAP:");
        maxHeap.printHeap();

        System.out.println("Deleting a value");
        maxHeap.delete(26);
        System.out.println("MAX HEAP:");
        maxHeap.printHeap();

        System.out.println("Extracting maximum value which is: "+maxHeap.extractMax());

        System.out.println("SORTED MAX HEAP");
        maxHeap.printSorted();



        //Task 04

        MaxHeap maxHeap4=new MaxHeap(15);
        Scanner input=new Scanner(System.in);
        for(int i=1;i<=10;i++){
            maxHeap4.insert(rand.nextInt(100));
        }
        System.out.println("MAX HEAP:");
        maxHeap4.printHeap();
        
        System.out.println("Enter the value of K between 1 to 10");
        int k=input.nextInt();
        if(k>=1&&k<=10){
            System.out.println(Arrays.toString(maxHeap4.nLargest(k)));
        }
        else System.out.println("Invalid input");
    }
}
