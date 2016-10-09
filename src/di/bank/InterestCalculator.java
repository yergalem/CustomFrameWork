
package di.bank;


//Context
public class InterestCalculator {
    
    private Interest strategy;

    public void setInterestStrategy(Interest strategy) {
        this.strategy = strategy;
    }

    public void createInterst(double principal, double rate, double time) {
        strategy.principalAfterInterest(principal, rate, time);
    }

}
