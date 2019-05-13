public class EmptyOperator implements IBinOp, IUnaryOp{
    public int apply(int number1) {
        return number1;
    }
    public int apply(int number1, int number2) {
        return number1;
    }
}
