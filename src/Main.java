import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("""
                                        
                    Hello!!
                    Please enter:
                    complex - if you want to work with complex numbers
                    matrix - if you want to work with matrix
                                        
                    """);
        String choice = console.nextLine();
        if (Objects.equals(choice, "complex")) {
            ComplexIO start = new ComplexIO();
            start.WorkWithComplex();
        }
        else if (Objects.equals(choice, "matrix")) {
            MatrixIO start = new MatrixIO();
            start.WorkWithMatrix();
        }
    }
}