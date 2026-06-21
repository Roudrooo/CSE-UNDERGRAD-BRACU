public class Test3{
    public static void main(String[] args){
        Circle r=new Circle();
        double R=r.radius;
        System.out.println("Radius of the circle is "+R);
        double pi=22.0/7.0;
        double area=pi*R*R,circumference=2*pi*R;
        System.out.println("The area of the circle is "+area+"\nThe circumference of the circle is "+circumference);
    }
}