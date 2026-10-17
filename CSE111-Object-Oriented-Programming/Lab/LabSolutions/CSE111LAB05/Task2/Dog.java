public class Dog {
    public String name;
    public String color;
    public void changeName(String s){
        name=s;
    }
    public void changeColor(String s){
        color=s;
        if(name==null){
            System.out.println("This dog is "+s);
        }else{
            System.out.println(name+" is "+s);
        }
    }
    public String bark(){
        if(name==null&&color==null){
            return "A dog is barking";
        }else if(name!=null&&color==null){
            return name+" is barking";
        }else if(name==null&&color!=null){
            return color+" dog is barking";
        }else{
            return name+" the "+color+" dog is barking";
        }
    }
}