public class Circle extends Shape{
    public double radius;
    public void area(){
        double area=Math.PI*Math.pow(radius,2);
        System.out.printf("Area of "+color+" Circle: %.2f\n",area);
    }
}