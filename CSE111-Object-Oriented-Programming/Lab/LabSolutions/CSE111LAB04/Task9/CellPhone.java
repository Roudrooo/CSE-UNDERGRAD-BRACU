public class CellPhone {
    public String model="unknown";
    String[] cont=new String[3];
    int idx=0,count=0;
    public void storeContact(String s){
        if(idx<3){
            cont[idx++]=s;
            System.out.println("Contact Stored");
        }else{
            System.out.println("Memory full. New contact can't be stored.");
        }
    }
    public void printDetails(){
        System.out.println("Phone Model "+model+"\nContacts Stored "+idx);
        if(count>0){
            System.out.println("Stored Contacts:");
        }
        for(int i=0;i<idx;i++){
            System.out.println(cont[i]);
        }
        count++;
    }
}
