package di.bank;


public class SimpleInterest implements Interest{

    @Override
    public double principalAfterInterest(double principal, double rate, double time) {
       return principal += (principal * time * rate / 100);
    }

	

}
