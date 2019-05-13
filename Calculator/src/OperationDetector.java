public class OperationDetector {
    IBinOp determinateBinary(String operation){
        switch (operation){
            case "+":
                return new Add();
            case "-":
                return new Subtract();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            case "^":
                return new Power();
            default:
                return new EmptyOperator();
        }
    }

    IUnaryOp determinateUnary(String operation){
        switch (operation){
            case "fib":
                return new Fibonacci();
            case "sin":
                return new Sinus();
            case "*":
            default:
                return new EmptyOperator();
        }
    }

}

