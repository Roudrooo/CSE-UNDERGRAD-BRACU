public class Cart{
    int crt_num;
    double discount;
    String[] crt=new String[3];
    double[] price=new double[3];
    public void create_cart(int n){
        crt_num=+n;
    }
    public void addItem(String n,double p){
        for(int i=0;i<3;i++){
            if(crt[i]==null){
                crt[i]=n;
                price[i]=p;
                System.out.println(crt[i]+" added to cart "+crt_num+".\nYou have "+(i+1)+" item(s) in your cart now.");
            }else{
                System.out.println("You already have 3 items on your cart");
            }
        }
    }
    public void cartDetails(){
        System.out.println("Your cart(c"+crt_num+") :");
        double sum=0;
        for(int i=0;i<3;i++){
            System.out.println(crt[i]+" - "+price[i]);
            sum+=price[i];
        }
        System.out.println("Discount Applied: "+discount+"%");
        double total=sum*((100.0-discount)/100.0);
        System.out.println("Total price: "+total);
    }
    public void giveDiscount(double n){
        discount=n;
    }
}