import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class MatrixIO {
    Matrix[] listOfMatrix = new Matrix[100];
    public void WorkWithMatrix() {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    
                    Work with MATRIX!
                    Please enter:
                    add - if you want to create new matrix
                    show - if you want to see all your matrix
                    choose - if you want to choose two matrix to do something
                    
                    """);

            String command = console.nextLine();

            if (command.isEmpty()) {
                System.out.println("String is empty!!");
            }
            switch (command) {
                case "add" -> addM();
                case "show" -> seeAllM();
                case "choose" -> chooseM();
            }
        }
    }
    public void addM() {
        Scanner console = new Scanner(System.in);
        System.out.println("You have to enter your matrix\n");
        System.out.println("Enter count of rows");
        try {
            int n = console.nextInt();
            System.out.println("Enter count of columns");
            try {
                int m = console.nextInt();
                int count = 0;

                for (int i = 0; i < 100; i++)
                    if (listOfMatrix[i] != null)
                        count++;

                listOfMatrix[count] = new Matrix(n, m);
                Complex[][] dataList = new Complex[n][m];

                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++) {
                        try {
                            System.out.println("Enter real part of complex number");
                            double a = console.nextDouble();

                            System.out.println("Enter imaginary part of complex number");
                            try {
                                double b = console.nextDouble();
                                dataList[i][j] = new Complex(a, b);
                            }
                            catch (InputMismatchException e) {
                                System.out.println("Please, input number which have type double!");
                                WorkWithMatrix();
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Please, input number which have type double!");
                            WorkWithMatrix();
                        }
                    }
                listOfMatrix[count].FillMatrix(dataList);
                System.out.println("\nYou added new matrix:\n");
                listOfMatrix[count].printMatrix();
                WorkWithMatrix();
            }
            catch (InputMismatchException e) {
                System.out.println("Please, input number which have type integer!");
                WorkWithMatrix();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Please, input number which have type integer!");
            WorkWithMatrix();
        }
    }
    public void seeAllM () {
        System.out.println("All your matrix:\n");
        for (int i = 0; i < listOfMatrix.length; i++)
            if (listOfMatrix[i] != null) {
                System.out.print("Number " + i + ":\n");
                listOfMatrix[i].printMatrix();
            }
        WorkWithMatrix();

    }
    public void chooseM () {
        Scanner console = new Scanner(System.in);
        int count = 0;

        for (int i = 0; i < 100; i++)
            if (listOfMatrix[i] != null)
                count++;

        System.out.print("\nNow you have to decide what do you want to do:\n(+, *, tran, det):\t");
        String operationType = console.nextLine();
        if (operationType.isEmpty()) {
            System.out.println("String is empty!!");
            WorkWithMatrix();
        }

        System.out.print("Enter number of first matrix:");
        try {
            int chooseFirst = console.nextInt();
            int chooseSecond = 0;
            if (!Objects.equals(operationType, "tran") && !Objects.equals(operationType, "det")){
                System.out.print("\nEnter number of second matrix:");
                try {
                    chooseSecond = console.nextInt();

                    switch (operationType) {
                        case "+" -> {
                            try {
                                listOfMatrix[count] = listOfMatrix[chooseFirst].AddMatrix(listOfMatrix[chooseSecond]);
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Please, input correct number of complex number!!");
                                WorkWithMatrix();
                            }
                        }
                        case "*" -> {
                            try {
                                listOfMatrix[count] = listOfMatrix[chooseFirst].MultiplyMatrix(listOfMatrix[chooseSecond]);
                            }
                            catch (Exception e) {
                                System.out.println("Please, input correct number of complex number!!");
                                WorkWithMatrix();
                            }
                        }
                        default -> {
                            System.out.println("Please, input correct operation!!");
                            WorkWithMatrix();
                        }
                    }

                    System.out.print("\nNew matrix number " + count + ":\t");
                    System.out.println("\n");
                    listOfMatrix[count].printMatrix();
                }
                catch (InputMismatchException e) {
                    System.out.println("Please, input number which have type integer!");
                    WorkWithMatrix();
                }
            }
            else if (Objects.equals(operationType, "tran")) {
                try {
                    listOfMatrix[count] = listOfMatrix[chooseFirst].TransposeMatrix();
                    listOfMatrix[count].printMatrix();
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please, input correct number of complex number!!");
                    WorkWithMatrix();
                }
            } else if (Objects.equals(operationType, "det")) {
                System.out.println("Determinant:\n");
                listOfMatrix[chooseFirst].CalcDet().PrintComplex();
                WorkWithMatrix();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Please, input number which have type integer!");
            WorkWithMatrix();
        }
        WorkWithMatrix();
    }
}