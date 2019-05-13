import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        System.out.println("Enter expression");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        int result = parser.parseExpression(expression);
        System.out.println(result);
    }
}
