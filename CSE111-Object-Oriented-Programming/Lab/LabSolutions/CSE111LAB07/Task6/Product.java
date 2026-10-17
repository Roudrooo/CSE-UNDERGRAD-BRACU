public class Product{
    private String name;
    private double price;
    private int quantity;
    public Product(){
        this.name="Unknown";
        this.price=0.0;
    }
    public Product(String name,double price){
        this.name=name;
        this.price=price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return this.price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void displayInfo(){
        System.out.print("Product Name: "+this.name+"\nPrice: $"+this.price);
    }
    public void displayInfo(boolean flag){
        displayInfo();
        if(flag) System.out.println("Quantity: "+this.quantity);
    }
}