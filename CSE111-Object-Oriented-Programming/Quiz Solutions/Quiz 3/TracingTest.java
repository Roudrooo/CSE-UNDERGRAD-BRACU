public class TracingTest {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2, 3);
        c1.add(4);
        ComplexNumber c2 = new ComplexNumber(1, 2);
        c2.add(3);
        c1.combine(c2);
    }
}