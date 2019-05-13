public class Power implements IBinOp {
    public int apply (int base, int power){
        return Math.toIntExact(Math.round(Math.pow(base, power)));
    }
}
