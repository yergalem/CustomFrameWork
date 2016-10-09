package di.bank;


public class CompoundInterest implements Interest{

    int n = 1;

    public CompoundInterest(int numberOfCompounds) {
        n = numberOfCompounds;
    }
    
    @Override
    public double principalAfterInterest(double p, double r, double t) {
         return p * Math.pow(1 + (r / n), n * t);
    }

}
