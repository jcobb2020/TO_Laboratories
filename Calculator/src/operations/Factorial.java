public class Factorial implements IUnaryOp{
    public int apply(int number1) {
        int result = 1;
        for (int i = 2; i<=number1; i++){
            result *=i;
        }
        return number1;
    }

}
