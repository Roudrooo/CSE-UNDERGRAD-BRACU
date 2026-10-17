public class MobilePhone {
    public int capacity;
    public String[] name;
    public int[] number;
    public MobilePhone(){
        capacity=0;
    }
    public void setContactCapacity(int n){
        capacity=n;
        name=new String[capacity];
        number=new int[capacity];
    }
    int idx=0;
    public void addContact(String name,int number){
        if(idx<capacity){
            this.name[idx]=name;
            this.number[idx]=number;
            idx++;
            System.out.println("The contact of "+name+" is added.");
        }else{
            System.out.println("Storage Full!!");
        }
    }
    public void makeCall(int number){
        boolean flag=false;
        for(int i=0;i<capacity;i++){
            if(this.number[i]==number){
                System.out.println("Calling "+this.name[i]+" . . .");
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Calling "+number+" . . .");
        }
    }
    public void details(){
        int count=0;
        for(int i=0;i<capacity;i++){
            if(this.number[i]!=0){
                count++;
            }
        }
        System.out.println("Total contacts: "+count+"\nContact List:");
        for(int i=0;i<capacity;i++){
            if(this.number[i]!=0){
                System.out.println(this.name[i]+":"+this.number[i]);
            }
        }
    }
}
