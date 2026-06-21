public class ComplexNumber {
    public static int real = 1, imag = 1;
    public int x, y;

    public ComplexNumber(int x, int y) {
        this.x = x;
        this.y = y;
        real += x;
        imag += y;
    }

    public void add(int n) {
        this.x = real + n;
        this.y = this.y + this.x + this.multiply();
        System.out.println(this.x + " + " + this.y);
    }

    public int multiply() {
        this.y = imag * this.y + this.x;
        System.out.println(this.x + " + " + this.y);
        real *= this.x;
        return this.y;
    }

    public void combine(ComplexNumber c) {
        c.y = this.imag * c.y + this.y;
        System.out.println(c.x + " + " + c.y);
    }
}

