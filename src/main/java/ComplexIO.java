import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
public class ComplexIO {
    Complex[] listOfComplex = new Complex[100];
    public void WorkWithComplex () throws Exception {
        Scanner console = new Scanner(System.in);
        while (true) {

            System.out.println("""
                                        
                    Work with COMPLEX NUMBERS!
                    Please enter:
                    add - if you want to create new complex number
                    show - if you want to see all your complex numbers
                    choose - if you want to choose two complex numbers to do something
                                        
                    """);

            String command = console.nextLine();

            if (command.isEmpty()) {
                System.out.println("String is empty!!");
            }
            switch (command) {
                case "add" -> addC();
                case "show" -> seeAllC();
                case "choose" -> chooseC();
            }
        }
    }
    public void addC () throws Exception {

        Scanner console = new Scanner(System.in);

        System.out.println("You have to enter your complex number\n");
        System.out.println("Enter real part of complex number");
        double a, b;

        try {
            a = console.nextDouble();
            System.out.println("Enter imaginary part of complex number");
            try {
                b = console.nextDouble();
                int count = 0;

                for (int i = 0; i < 100; i++)
                    if (listOfComplex[i] != null)
                        count++;

                listOfComplex[count] = new Complex(a, b);
                System.out.println("\nYou added new complex number:");
                listOfComplex[count].PrintComplex();
                WorkWithComplex();
            }
            catch (InputMismatchException e) {
                System.out.println("Please, input number which have type double!");
                WorkWithComplex();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Please, input number which have type double!");
            WorkWithComplex();
        }
    }
    public void seeAllC() throws Exception {
        System.out.println("All your complex number:");
        for (int i = 0; i < listOfComplex.length; i++)
            if (listOfComplex[i] != null) {
                System.out.print("Number " + i + ":\t");
                listOfComplex[i].PrintComplex();
                System.out.println();
            }
        WorkWithComplex();
    }
    public void chooseC() throws Exception {
        Scanner console = new Scanner(System.in);
        int count = 0;

        for (int i = 0; i < 100; i++)
            if (listOfComplex[i] != null)
                count++;

        System.out.print("\nNow you have to decide what do you want to do:\n(+, -, *, trig):\t");
        String operationType = console.nextLine();
        if (operationType.isEmpty()) {
            System.out.println("String is empty!!");
            WorkWithComplex();
        }

        System.out.print("Enter number of first complex number:");
        try {
            int chooseFirst = console.nextInt();
            int chooseSecond = 0;
            if (!Objects.equals(operationType, "trig")){
                System.out.print("\nEnter number of second complex number:");
                try {
                    chooseSecond = console.nextInt();

                    switch (operationType) {
                        case "+" -> {
                            try {
                                listOfComplex[count] = listOfComplex[chooseFirst].AddComplex(listOfComplex[chooseSecond]);
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Please, input correct number of complex number!!");
                                WorkWithComplex();
                            }
                        }
                        case "-" -> {
                            try{
                                listOfComplex[count] = listOfComplex[chooseFirst].SubComplex(listOfComplex[chooseSecond]);
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Please, input correct number of complex number!!");
                                WorkWithComplex();
                            }
                        }
                        case "*" -> {
                            try {
                                listOfComplex[count] = listOfComplex[chooseFirst].MultiplyComplex(listOfComplex[chooseSecond]);
                            }
                            catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Please, input correct number of complex number!!");
                                WorkWithComplex();
                            }
                        }
                        default -> {
                            System.out.println("Please, input correct operation!!");
                            WorkWithComplex();
                        }
                    }

                    System.out.print("\nNew complex number " + count + ":\t");
                    System.out.println("\n");
                    listOfComplex[count].PrintComplex();
                }
                catch (InputMismatchException e) {
                    System.out.println("Please, input number which have type integer!");
                    WorkWithComplex();
                }
            }
            else {
                try {
                    listOfComplex[chooseFirst].PresentInTrigForm();
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Please, input correct number of complex number!!");
                    WorkWithComplex();
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Please, input number which have type integer!");
            WorkWithComplex();
        }
        WorkWithComplex();
    }
}

