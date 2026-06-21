public class Bird{
    public String name;
    int u=0;
    public void flyUp(int x){
        u+=x;
        System.out.printf("%s has flown up %d feet.\n",name,x);
    }
    public void flyDown(int x){
        if(x>u){
            System.out.printf("%s cannot fly down %d feet.\n",name,x);
        }else if(x<u){
            u-=x;
            System.out.printf("%s has flown down %d feet.\n",name,x);
        }else{
            System.out.printf("%s has flown down %d feet and landed.\n",name,x);
        }
    }
    public void makeNoise(){
        if("Parrot".equals(name)){
            System.out.println("Squawk");
        }else if("Eagle".equals(name)){
            System.out.println("Squee");
        }
    }
}