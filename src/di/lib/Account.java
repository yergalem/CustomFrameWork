package di.lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import di.frwk.Koin;

public class Account implements IAccount, Iterable {
	
	private Long accNumber;
	private List<IEntry> entries;
	private boolean isActive;
	private ICustomer customer;

	public Account() {
		entries = new ArrayList<>();
	}

	public Account(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		this.accNumber = accNumber;
		this.entries = entries != null ? entries : new ArrayList<>();
		this.isActive = isActive;
		this.customer = customer;
	}

	public static Account createAccount(String acct) {
	   return null;
	}

	@Override
	public Long getAccNumber() {
		return accNumber;
	}

	@Override
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}
	
	public static IAccount searchAccount( Long acctNo) {
		
		 return DBHelper.searchAccount(acctNo);
	}

	@Override
	public ICustomer getCustomer() {
		return customer;
	}

	@Override
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public boolean getIsActive() {
		return isActive;
	}

	@Override
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	@Override
	public void addInterest() {
		double interest = getBalance() * getInterestRate();
		addEntry(interest);
	}

	@Override
	public double getInterestRate() {
		return 0.0;
	}

	@Override
	public IEntry addEntry(double amount) {
		IEntry entry = new Entry(amount);// Injector.createObject("entry",
											// amount);
		entry.setAmount(amount);
		entry.setAccount(this);
		entries.add(entry);
		DBHelper.addEntry(entry);
		return entry;
	}

	@Override
	public List<IEntry> getEntries() {
		return entries;
	}

	@Override
	public void deposit(double amount) {
		IEntry entry = addEntry(amount);

		customer.sendEmail(entry);
	}

	@Override
	public void withdraw(double amount) {
		IEntry entry = addEntry(amount * -1);
		customer.sendEmail(entry);
	}

	@Override
	public double getBalance() {
	 return entries.stream().mapToDouble(e -> e.getAmount()).sum();
		//return balance;
	}

	@Override
	public void generateReport() {
		// TODO implement here
	}

	@Override
	public String toString() {
		return accNumber.toString();
	}

	public void createAccount() {
	}
		
	
	@Override
	public Iterator iterator() {

		return new AccountData();
	}

	private class AccountData implements Iterator {

		List<IAccount> accounts;
		IAddress addr;
		IAccount account;
		int index = 0;

		private AccountData() {
			accounts = DBHelper.getAllAccounts();
		}

		@Override
		public boolean hasNext() {

			if (accounts.size() > index) {
				account = accounts.get(index);

				return true;
			}
			return false;
		}

		@Override
		public Object[] next() {
			Object[] rowdata = null;

			ICustomer customer = account.getCustomer();
			addr = customer.getAddress();
			rowdata = new Object[ Koin.getActiveApp().getColumns().length];
			rowdata[0] = account.getAccNumber();
			rowdata[1] = customer.getName();
			rowdata[2] = addr.getCity();
			rowdata[3] = addr.getZip();
			rowdata[4] = customer.getType();
			rowdata[5] = account.getAcctType().getCatName();
			rowdata[6] = account.getBalance();

			index++;
		

			return rowdata;
		}

	}

	@Override
	public  AccountType getAcctType(){ return null; }

}
