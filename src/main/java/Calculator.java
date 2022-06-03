import java.util.Scanner;

public class Calculator {
    static double firstNumber ;
    static double secondNumber ;
    static char operation;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        firstNumber = getNumber();
        secondNumber = getNumber();
        operation = getOperation();
        double result = calculate(firstNumber, secondNumber, operation);
        System.out.println("Результат операции: " + result);
    }

    public static double getNumber() {
        System.out.println("Введите число:");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не число или число в неверном формате." +
                    "\nРазрешенные форматы: 5/-5 ; 2,5/-2,5 ; NaN ; Infinity/-Infinity." +
                    "\nПопробуйте еще раз.");
            scanner.next();
            number = getNumber();
        }
        return number;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Calculator может осуществляет только следующие операции : +,-,/,*. Выберите одну из них.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static double calculate(double x, double y, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = sum(x,y);
                break;
            case '-':
                result = subtract(x,y);
                break;
            case '*':
                result = multiply(x,y);
                break;
            case '/':
                result = divide(x,y);
            break;
            default:
                System.out.println("Calculator может осуществляет только следующие операции - +,-,/,*. Выберите одну из них.");
                result = calculate(x, y, getOperation());
        }
        return result;
    }
    private static double sum(double a,double b){
        return a + b;
    }
    private static double subtract(double a,double b){
        return a - b;
    }
    private static double multiply(double a,double b){
        return a * b;
    }
    private static double divide(double a,double b){
        if (b==0){
            System.out.println("Недопустимая операция. Деление на ноль. Введите другое число");
            b = getNumber();
        }
         return a / b;
    }
}
