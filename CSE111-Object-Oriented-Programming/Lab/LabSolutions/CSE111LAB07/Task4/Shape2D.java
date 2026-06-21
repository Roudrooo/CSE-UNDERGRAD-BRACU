public class Shape2D{
    public double area;
    public int length;
    public int breadth;
    public int height;
    public int base;
    public String shape;
    public Shape2D(int length){
        this.length=length;
        System.out.println("A Square has been created with length: "+this.length);
        this.area=this.length*this.length;
        this.shape="Square";
    }
    public Shape2D(int length,int breadth){
        this.length=length;
        this.breadth=breadth;
        System.out.println("A Rectangle has been created with length: "+this.length+" and breadth:  "+this.breadth);
        this.area=this.length*this.breadth;
        this.shape="Rectangle";
    }
    public Shape2D(int height,int base,String name){
        this.height=height;
        this.base=base;
        System.out.println("A Triangle has been created with height: "+this.height+" and base:  "+this.base);
        this.area=0.5d*this.height*this.base;
        this.shape="Triangle";
    }
    public Shape2D(int a,int b,int c){
        System.out.printf("A Triangle has been created with the following sides: %d, %d, %d\n",a,b,c);
        this.area=this.length*this.length;
        double s=(a+b+c)/2.0;
        this.area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        this.shape="Triangle";
    }
    public void area(){
        System.out.println("The area of the "+this.shape+" is: "+this.area);
    }
}