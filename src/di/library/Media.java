package di.library;

public class Media implements LoanItem {

    double fine;
    Member mem;
    
    public Media(Member mem) {
        this.mem = mem;
    }

    public double getFine() {
        return mem.getMaturity() == "A" ? 0.10 : 0.05;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public Member getMem() {
        return mem;
    }

    public void setMem(Member mem) {
        this.mem = mem;
    }

    @Override
    public void accept(FineCal fn) {
        fn.visit(this);
    }

}
