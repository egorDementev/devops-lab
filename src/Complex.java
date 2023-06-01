public class Complex {
    /**
     * real and imaginary part of complex number
     */
    double a, b;
    Complex (double first, double second) {
        a = first;
        b = second;
    }

    /**
     * adds this number with another
     * @param other another complex number
     * @return the sum of two numbers as new complex number
     */
    public Complex AddComplex(Complex other) {
        double new_a = a + other.a;
        double new_b = b + other.b;
        return new Complex(new_a, new_b);

    }

    /**
     * counts the difference of this number with another
     * @param other another complex number
     * @return the difference of two numbers as new complex number
     */
    public Complex SubComplex(Complex other) {
        double new_a = a - other.a;
        double new_b = b - other.b;
        return new Complex(new_a, new_b);
    }

    /**
     * multiplies this number by another
     * @param other another complex number
     * @return multiplication of two numbers as new complex number
     */
    public Complex MultiplyComplex(Complex other) {
        double new_a = a * other.a + b * other.b * (-1);
        double new_b = a * other.b + other.a * b;
        return new Complex(new_a, new_b);
    }

    /**
     * represents a complex number in trigonometric form and print it
     */
    public void PresentInTrigForm() {
        double absComplex = Math.hypot(a, b);
        double arg = Math.atan2(b, a);
        System.out.println("Complex number = "+ absComplex + "(cos(" + arg + ") + sin(" + arg + "))");
    }

    /**
     * this function just print complex number on screen
     */
    public void PrintComplex() {
        System.out.print(a + " + (" + b + ")i");
    }
}
