public class MoneyTracker {
    public String name;
    public float balance;
    public String info(){
        return "Name: "+name+"\nCurrent Balance: "+balance;
    }
    public void createTracker(String n){
        name=n;
        balance=1.0f;
    }
    float last_a=0,last_s=0;
    public void income(float i){
        balance+=i;
        last_a=i;
        System.out.println("Balance Updated!");
    }
    public void expense(float e){
        balance-=e;
        last_s=e;
        if(balance==0){
            System.out.println("You're broke!");
        }else if(balance<0){
            System.out.println("Not enough balance.");
        }else{
            System.out.println("Balance Updated.");
        }
    }
    public void showHistory(){
        System.out.println("Last added: "+last_a+"\nLast spent: "+last_s);
    }
}
