public class Sinus implements IUnaryOp {
    public int apply(int number){
        return Math.toIntExact(Math.round(Math.sin(number)));
    }
}
