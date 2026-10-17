// Task04: Word Decoder
public class Task2 {

    public static Node wordDecoder( Node head ){
        
        //You're suppose to create a new Dummy headed Singly Linked List in this method
        //Dummy head is basically a head Node where the elem is null
        // Node dHead = new Node(null, null); here the dHead is a Dummy Head

        //TO DO
        int count=0;
        Node tail=head;
        while(tail!=null){
            count++;
            tail=tail.next;
        }
        tail=head;
        Node dHead=new Node(null,null),dTail=dHead;
        int idx=0,step=13%count;
        while(tail!=null){
            if(idx%step==0&&idx!=0){
                dTail.next=tail;
                dTail=dTail.next;
            }
            tail=tail.next;
            idx++;
        }
        if(dTail!=null){ // If there is any character left in the last
            dTail.next=null; 
        }
        dTail=dHead.next;
        Node prv=null,nxt;
        while(dTail!=null){
            nxt=dTail.next;
            dTail.next=prv;
            prv=dTail;
            dTail=nxt;
        }
        dHead.next=prv;
        //remove the following line when you're ready to return the new head
        return dHead;
    }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT TOUCH THE DRIVER CODE BELOW
    public static void main(String[] args){
        System.out.println("==============Test Case 1=============");
        Node head = LinkedList.createList(new Character[]{'B', 'M', 'D', 'T', 'N', 'O', 'A', 'P', 'S', 'C'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> C -> A -> T");
        Node result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> C -> A -> T
        System.out.println();
        System.out.println("==============Test Case 2=============");
        head = LinkedList.createList(new Character[]{'Z', 'O', 'T', 'N', 'X'});
        System.out.print("Encoded Word: ");
        LinkedList.printLL(head);
        System.out.println("\nExpected output: null -> N");
        result = wordDecoder(head);
        System.out.println( "Your output: ");
        LinkedList.printLL(result); //This should print null -> N
        System.out.println();
    }
}
