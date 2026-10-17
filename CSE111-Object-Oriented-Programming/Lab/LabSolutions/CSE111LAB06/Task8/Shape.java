public class Shape {
    public String name;
    public double area;
    public Shape(){
        name=null;
        area=0;
    }
    public void setParameters(String name,int a){
        this.name=name;
        area=3.1416d*a*a;
    }
    public void setParameters(String name,int a,int b){
        this.name=name;
        area=(1d/2d)*a*b;
    }
    public void setParameters(String name,int a,int b,int c){
        this.name=name;
        area=(1d/2d)*(a+b)*c;
    }
    public String details(){
        return "Shape Name: "+name+"\nArea : "+area;
    }
}
