public static Node alternateMerge( Node head1, Node head2 ){
        
        //You’re NOT ALLOWED to create a new singly linked list for this task

        //TO DO
        Node tail1=head1,tail2=head2,temp1,temp2;
        while(tail1!=null&&tail2!=null){
            temp1=tail1.next; // Keeping next position in hand
            temp2=tail2.next;
            tail1.next=tail2;
            if(temp1==null){ // If 1st linked list is shorter
                tail2.next=temp2; // Linking with the same list(2nd)
                break;
            }
            tail2.next=temp1;
            tail1=temp1;
            tail2=temp2;
        }
        //remove the following line when returning the Head of the modified LinkedList
        return head1;
    }