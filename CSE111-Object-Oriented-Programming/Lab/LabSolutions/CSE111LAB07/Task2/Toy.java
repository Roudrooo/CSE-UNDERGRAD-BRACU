public class Toy{
    public String name;
    public int price;
    public Toy(String name,int price){
        System.out.println("A new toy has been made!");
        this.name=name;
        this.price=price;
    }
    public void updatePrice(int price){
        this.price=price;
    }
    public void showPrice(){
        System.out.printf("price: %d Taka\n",this.price);
    }
    public void updateName(String name){
        System.out.printf("Changing old name: %s\n",this.name);
        this.name=name;
        System.out.printf("Cnew name: %s\n",this.name);
    }
}