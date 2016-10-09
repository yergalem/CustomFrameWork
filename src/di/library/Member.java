package di.library;

import java.util.ArrayList;
import java.util.List;

public class Member {
  String maturity;
  List<LoanItem> items;
  
    public Member(String m) {
    	maturity = m;
    	items = new ArrayList<>();
	}

	public String getMaturity() {
		return maturity;
	}

	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}

	public List<LoanItem> getItems() {
		return items;
	}

	public void setItems(List<LoanItem> items) {
		this.items = items;
	}
    
    
    
    
}
