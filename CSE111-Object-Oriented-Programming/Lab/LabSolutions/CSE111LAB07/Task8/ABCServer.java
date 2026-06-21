public class ABCServer{
    public String name;
    public int capacity;
    public int member;
    public String[] members;
    public String[] role;
    public int idx=0;
    public ABCServer(){
        this.name="Default";
        this.capacity=10;
        this.member=0;
        this.members=new String[this.capacity];
        this.role=new String[this.capacity];
        for(int i=0;i<this.capacity;i++){
            role[i]="Rising Hero";
        }
    }
    public ABCServer(String name,int capacity){
        this.name=name;
        this.capacity=capacity;
        this.member=0;
        this.members=new String[this.capacity];
        this.role=new String[this.capacity];
        for(int i=0;i<this.capacity;i++){
            role[i]="Rising Hero";
        }
    }
    public void addMembers(String members){
        if(this.capacity>=idx+1){
            this.members[idx++]=members;
            System.out.println("Rising Hero is added.");
        }
        else{
            System.out.println("Sorry, maximum capacity exceeded!");
        }
    }
    public void addMembers(String members,String role){
        if(this.capacity>=idx+1){
            this.members[idx]=members;
            this.role[idx++]=role;
            System.out.println(role+" is added.");
        }
        else{
            System.out.println("Sorry, maximum capacity exceeded!");
        }
    }
    public void details(){
        int count=0;
        System.out.println("Server Name: "+this.name+"\nMember Capacity: "+this.capacity);
        for(int i=0;i<this.capacity;i++){
            if(this.members[i]!=null) count++;
        }
        System.out.println("Total Members: "+count+"\nMembers:");
        for(int i=0;i<count;i++){
            System.out.println("Name:Role --> "+this.members[i]+":"+this.role[i]);
        }
    }
}