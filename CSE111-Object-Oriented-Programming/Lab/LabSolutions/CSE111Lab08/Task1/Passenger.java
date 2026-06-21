public class Passenger{
    public static int no_of_passenger=0;
    public static double total_fare=0.0;
    public String name;
    public double weight;
    public double bagweight;
    public double fare;
    public Passenger(String name,double weight){
        this.name=name;
        this.weight=weight;
        this.fare=0.0;
        no_of_passenger++;
    }
    public void setBaggageWeight(double bagweight){
        this.bagweight=bagweight;
    }
    public void passengerDetails(){
        this.fare=20*weight+10*bagweight;
        total_fare+=this.fare;
        System.out.println("Name: "+this.name+"\nFare: "+this.fare+" TK");
    }
}