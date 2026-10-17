public class UniversityTester {
    public static void main(String[] args) {
        University x1=new University();
        University x2=new University();
        // a
        System.out.println("Location for x1: "+x1);
        System.out.println("Location for x2: "+x2);
        System.out.println("For x1: \n"+x1.name+"\n"+x1.country);
        System.out.println("For x2: \n"+x2.name+"\n"+x2.country);
        // The location of the objects are not the same.

        // b 
        x1.name="Imperial College London";
        x1.country="England";
        x2.name="Brac University";
        x2.country="Bangladesh";
        System.out.println("For x1: \n"+x1.name+"\n"+x1.country);
        System.out.println("For x2: \n"+x2.name+"\n"+x2.country);
        // The instance variables of both objects are not of the same value.
    }
}