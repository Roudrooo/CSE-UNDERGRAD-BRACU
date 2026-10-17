public class Parcel{
    public String name;
    public int weight;
    public double fee;
    public Parcel(){
        this.name=null;
        this.weight=0;
        this.fee=0.0;
    }
    public Parcel(String name){
        this.name=name;
        this.weight=0;
        this.fee=0.0;
    }
    public Parcel(String name,int weight){
        this.name=name;
        this.weight=weight;
        this.fee=0.0;
    }
    public void addWeight(int weight){
        this.weight+=weight;
        System.out.println("Updated Weight: "+this.weight);
    }
    public void calcFee(String place){
        if(this.weight!=0){
            if(place.equals("Dhanmondi")){
                this.fee=this.weight*20d+50;
            }else{
                this.fee=this.weight*20d;
            }
        }else{
            this.fee=0.0;
        }
    }
    public void printDetails(){
        if(this.name==null){
            System.out.println("Set name first");
        }else{
            System.out.println("Name: "+this.name+"\nTotal Weight: "+this.weight+"\nTotal Fee: "+this.fee);
        }
    }
}
