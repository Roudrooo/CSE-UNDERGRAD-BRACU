public class Cargo{
    public static double cargoCapacity=10.0;
    public static int cargoId=0;
    public int id;
    public String content;
    public double weight;
    public boolean loaded;
    public Cargo(String content, double weight){
        cargoId++;
        this.id=cargoId;
        this.content=content;
        this.weight=weight;
        loaded=false;
    }
    public static double capacity(){
        if(cargoCapacity==0.9999999999999998){
            cargoCapacity=1.0;
        }
        return cargoCapacity;
    }
    public void load(){
        if(!loaded){
            loaded=true;
            if(cargoCapacity<weight){
                System.out.println("Cannot load cargo, exceeds weight capacity.");
                loaded=false;
            }
            else{
                cargoCapacity-=weight;
                System.out.println("Cargo "+this.id+" loaded for transport");
            }
        }
    }
    public void unload(){
        if(loaded){
            loaded=false;
            cargoCapacity+=weight;
            System.out.println("Cargo "+this.id+" unloaded");}
    }
    public void details(){
        System.out.println("Cargo ID: "+this.id+", Contents: "+content+", Weight: "+weight+", Loaded: "+loaded);
    }
}