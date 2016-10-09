package di.library;

import di.lib.Book;


class LoanItemFineCal implements FineCal {
	double total;
	public LoanItemFineCal() {
	
		
	}

    public double getTotal() {
       
        return total;
    }

   
	@Override
	public void visit(Book b) {
	   total += b.getFine();
               
	}

    public void setTotal(double total) {
        this.total = total;
    }

	@Override
	public void visit(Magazine m) {
            total+=m.getFine();
	}

	@Override
	public void visit(Media n) {
            total+=n.getFine();		
	}
}






