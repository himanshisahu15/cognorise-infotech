import java.util.Scanner;

public class ScientificCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Scientific Calculator");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Trigonometric Functions");
            System.out.println("7. Clear");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performAddition(scanner);
                    break;
                case 2:
                    performSubtraction(scanner);
                    break;
                case 3:
                    performMultiplication(scanner);
                    break;
                case 4:
                    performDivision(scanner);
                    break;
                case 5:
                    performSquareRoot(scanner);
                    break;
                case 6:
                    performTrigonometricFunctions(scanner);
                    break;
                case 7:
                    clear();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void performAddition(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double result = num1 + num2;
        System.out.println("Result: " + result);
    }

    private static void performSubtraction(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double result = num1 - num2;
        System.out.println("Result: " + result);
    }

    private static void performMultiplication(Scanner scanner) {
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double result = num1 * num2;
        System.out.println("Result: " + result);
    }

    private static void performDivision(Scanner scanner) {
        System.out.print("Enter the dividend: ");
        double dividend = scanner.nextDouble();
        System.out.print("Enter the divisor: ");
        double divisor = scanner.nextDouble();
        if (divisor == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return;
        }
        double result = dividend / divisor;
        System.out.println("Result: " + result);
    }

    private static void performSquareRoot(Scanner scanner) {
        System.out.print("Enter the number: ");
        double num = scanner.nextDouble();
        if (num < 0) {
            System.out.println("Error: Cannot calculate square root of a negative number!");
            return;
        }
        double result = Math.sqrt(num);
        System.out.println("Result: " + result);
    }

    private static void performTrigonometricFunctions(Scanner scanner) {
        System.out.print("Enter the angle (in degrees): ");
        double angleDegrees = scanner.nextDouble();
        double angleRadians = Math.toRadians(angleDegrees);
        System.out.println("Sin(" + angleDegrees + "): " + Math.sin(angleRadians));
        System.out.println("Cos(" + angleDegrees + "): " + Math.cos(angleRadians));
        System.out.println("Tan(" + angleDegrees + "): " + Math.tan(angleRadians));
    }

    private static void clear() {
        // Simply clear the console output for simplicity
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}