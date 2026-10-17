public class Task3 {
    public static Node idGenerator(Node head1, Node head2, Node head3) {
        
        //TO DO
        //Hint: the Node elements are actually Object, you can type cast them
        //      into int or Integer like the following:
        //        (int)n.elem  or  (Integer)n.elem
        Node tail1=head1,tail2=head2,tail3=head3;
        Node prv=null,nxt;
        while(tail1!=null){
            nxt=tail1.next;
            tail1.next=prv;
            prv=tail1;
            tail1=nxt;
        }
        Node revHead1=prv;
        Node sumHead=new Node(null,null),sumTail=sumHead;
        int sum;
        while(tail2!=null&&tail3!=null){
            if(((int)tail2.elem+(int)tail3.elem)>9){
                sum=((int)tail2.elem+(int)tail3.elem)%10;
            }else{
                sum=(int)tail2.elem+(int)tail3.elem;
            }
            sumTail.next=new Node(sum,null);
            sumTail=sumTail.next;
            tail2=tail2.next;
            tail3=tail3.next;
        }
        Node revTail1=revHead1;
        while(revTail1.next!=null) revTail1=revTail1.next;
        revTail1.next=sumHead.next;
        return revHead1; // Remove this when you're ready to return the new head
    }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT MAKE ANY MODIFICATIONS IN THE TESTER CODE BELOW
    public static void main(String[] args) {
        System.out.println("=========Test Case 1=============");
        Node head1 = LinkedList.createList(new Integer[]{0, 3, 2, 2});
        Node head2 = LinkedList.createList(new Integer[]{5, 2, 2, 1});
        Node head3 = LinkedList.createList(new Integer[]{4, 3, 2, 1});

        System.out.print("LinkedList#1:  ");
        LinkedList.printLL(head1); // This should print 0 -> 3 -> 2 -> 2

        System.out.print("LinkedList#2:  ");
        LinkedList.printLL(head2); // This should print 5 -> 2 -> 2 -> 1

        System.out.print("LinkedList#3:  ");
        LinkedList.printLL(head3); // This should print 4 -> 3 -> 2 -> 1

        Node result = Task3.idGenerator(head1, head2, head3);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result); // This should print 2 -> 2 -> 3 -> 0 -> 9 -> 5 -> 4 -> 2

        System.out.println("\n=========Test Case 2=============");
        Node head4 = LinkedList.createList(new Integer[]{0, 3, 9, 1});
        Node head5 = LinkedList.createList(new Integer[]{3, 6, 5, 7});
        Node head6 = LinkedList.createList(new Integer[]{2, 4, 3, 8});

        System.out.print("LinkedList#4:  ");
        LinkedList.printLL(head4); // This should print 0 -> 3 -> 9 -> 1

        System.out.print("LinkedList#5:  ");
        LinkedList.printLL(head5); // This should print 3 -> 6 -> 5 -> 7

        System.out.print("LinkedList#6:  ");
        LinkedList.printLL(head6); // This should print 2 -> 4 -> 3 -> 8

        Node result2 = Task3.idGenerator(head4, head5, head6);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result2); // This should print 1 -> 9 -> 3 -> 0 -> 5 -> 0 -> 8 -> 5
    }
}
