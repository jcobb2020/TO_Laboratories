import java.util.Stack;

public class Parser {

    public Parser() {
        numberStack = new Stack<String>();
        detector = new OperationDetector();
    }

    private Stack<String> numberStack;
    OperationDetector detector;

    public int parseExpression(String expression) {
        expression = reverseString(expression);
        StringBuilder numberBuilder = new StringBuilder();
        StringBuilder operatorBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                if (operatorBuilder.length() > 0) {
                    numberStack.push(reverseString(operatorBuilder.toString()));
                    operatorBuilder = new StringBuilder();
                }
                numberBuilder.append(c);
                if(i==expression.length()-1){
                    numberStack.push(reverseString(numberBuilder.toString()));
                }
            } else {
                if (numberBuilder.length() > 0) {
                    numberStack.push(reverseString(numberBuilder.toString()));
                    numberBuilder = new StringBuilder();
                }
                operatorBuilder.append(c);
                if(i==expression.length()-1){
                    numberStack.push(reverseString(operatorBuilder.toString()));
                }
            }
        }
        int number=0;
        int number2;
        while (numberStack.size() > 1) {
            String s = numberStack.pop();

            if (detector.determinateUnary(s) instanceof EmptyOperator) {
                if (detector.determinateBinary(s) instanceof EmptyOperator) {
                    number = Integer.parseInt(s);
                } else {
                    number2 = Integer.parseInt(numberStack.pop());
                    numberStack.push(Integer.toString(detector.determinateBinary(reverseString(s)).apply(number, number2)));
                }
            }else{
                number2 = Integer.parseInt(numberStack.pop());
                numberStack.push(Integer.toString(detector.determinateUnary(s).apply(number2)));
            }
        }
        return Integer.parseInt(numberStack.pop());
    }

    private String reverseString(String s){
        StringBuilder builder = new StringBuilder();
        StringBuilder old = new StringBuilder(s);
        while (old.length()!=0){
            builder.append(old.charAt(old.length()-1));
            old.deleteCharAt(old.length()-1);
        }
        return builder.toString();
    }
}

