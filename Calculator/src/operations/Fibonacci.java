public class Fibonacci implements IUnaryOp {
    public int apply(int number){
        int a = 0;
        int b = 1;
        if(number==0){
            return 0;
        }
        if(number==1 || number==2){
            return 1;
        }
        for (int i=2; i<=number; i++){
            b = a+b;
            a = b-a;
        }
        return b;
    }
}
