public class Complex {
    private double real; 
    private double imaginary;

   
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

   
    public double getReal() {
        return real;
    }

   
    public double getImaginary() {
        return imaginary;
    }

    
    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    
    public Complex subtract(Complex other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    
    public Complex multiply(Complex other) {
        double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
        double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
        return new Complex(newReal, newImaginary);
    }

    
    public Complex divide(Complex other) {
        double denominator = (other.real * other.real) + (other.imaginary * other.imaginary);
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero complex number is not allowed.");
        }
        double newReal = ((this.real * other.real) + (this.imaginary * other.imaginary)) / denominator;
        double newImaginary = ((this.imaginary * other.real) - (this.real * other.imaginary)) / denominator;
        return new Complex(newReal, newImaginary);
    }

    
    @Override
    public String toString() {
        if (imaginary == 0) return String.format("%.2f", real);
        if (real == 0) return String.format("%.2fi", imaginary);
        if (imaginary < 0) return String.format("%.2f - %.2fi", real, Math.abs(imaginary));
        return String.format("%.2f + %.2fi", real, imaginary);
    }

    public static void main(String[] args) {
        Complex a = new Complex(2.0, 3.0);
        Complex b = new Complex(1.0, -2.0);

        System.out.println("Complex Number a: " + a);
        System.out.println("Complex Number b: " + b);

        Complex sum = a.add(b);
        System.out.println("Sum (a + b): " + sum);

        Complex difference = a.subtract(b);
        System.out.println("Difference (a - b): " + difference);

        Complex product = a.multiply(b);
        System.out.println("Product (a * b): " + product);

        try {
            Complex quotient = a.divide(b);
            System.out.println("Quotient (a / b): " + quotient);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        Complex c = new Complex(0.0, 0.0);
        try {
            a.divide(c);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero: " + e.getMessage());
        }
    }
}
