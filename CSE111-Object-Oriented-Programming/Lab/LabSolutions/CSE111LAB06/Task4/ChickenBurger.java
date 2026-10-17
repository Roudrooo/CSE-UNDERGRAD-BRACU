public class ChickenBurger{
    public String bun;
    public int price;
    public String sauceOption;
    public String spiceLevel;
    public ChickenBurger(){
        bun="Sesame";
        price=200;
        sauceOption="Less";
        spiceLevel="Not Set";
    }
    public void customizeSpiceLevel(String s){
        if(s.equals("Mild")||s.equals("Spicy")||s.equals("Naga")||s.equals("Extreme")){
            spiceLevel=s;
            System.out.println("Spice level set to "+spiceLevel+".");

        }else{
            System.out.println("This spice level is unavailable.");
        }
    }
    public String serveBurger(){
        if(spiceLevel.equals("Not Set")){
            return "Cannot serve now. Customize Spice Level first.";
        }else{
            return "The burger is being served:-\nBun Type: "+bun+"\nPrice: "+price+"\nSauce Option: "+sauceOption+"\nSpice Level: "+spiceLevel;
        }
    }  
}