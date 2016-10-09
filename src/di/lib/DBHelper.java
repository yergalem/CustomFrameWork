package di.lib;

import java.util.*;

import di.bank.form.BankStaff;
import di.cc.form.CreditStaff;


public class DBHelper {
	
	private static List<IAccount> accounts = new ArrayList<>();
	private static List<ICustomer> customers = new ArrayList<ICustomer>();
	private static List<IEntry> entries = new ArrayList<IEntry>();
	private static DBHelper dbHelperInstance = new DBHelper();
	private static List<Book> books = new ArrayList<>();
	private static List<BankStaff> bankStaff;
	private static List<CreditStaff> creditStaff = new ArrayList<>();
	
	public DBHelper(){
		
		bankStaff = new ArrayList<>();
        BankStaff bn = new BankStaff();
        bn.setFname("Abebe");
        bn.setLname("Abebe");
        bn.setAge(20);
        bn.setGender("Male");
        bn.setPassword("123456");
        bn.setUsername("mum");
        
        bankStaff.add(bn);
	}
	
	public static List<Book> getBooks() {
		return books;
	}

	public static List<BankStaff> getBankStaff() {
		return bankStaff;
	}

	public static void setBankStaff(List<BankStaff> bankStaff) {
		DBHelper.bankStaff = bankStaff;
	}

	public static List<CreditStaff> getCreditStaff() {
		return creditStaff;
	}

	public static void setCreditStaff(List<CreditStaff> creditStaff) {
		DBHelper.creditStaff = creditStaff;
	}

	
	public static  DBHelper getDBHelperInstance(){
		return dbHelperInstance;
	}
	
	public static IAccount getAccount(long accNumber) throws Exception {
		Optional<IAccount> account = accounts.stream().filter(a -> a.getAccNumber() == accNumber).findAny();
		if(account.isPresent())
			return account.get();
		else
			throw new Exception("Account not found!");
	}
	
	public static void addAccount(IAccount account) {
		   accounts.add(account);
		
	}
	
	public static void addBankStaff(BankStaff staff) {
		   bankStaff.add(staff);	
	}

	public static void addCreditStaff(CreditStaff staff) {
		   creditStaff.add(staff);	
	}
	
	public static void addBook(Book book) {
		   books.add(book);
		
	}
	
	public static void addCustomer(ICustomer customer) {
		customers.add(customer);
	}

	public static void addEntry(IEntry entry) {
		entries.add(entry);
	}

	public static long getMaxAccountNumber() {
		
		OptionalLong maxAccNo = accounts.stream().mapToLong(a -> a.getAccNumber()).max();
		if(maxAccNo.isPresent())
			return maxAccNo.getAsLong();
		else
			return 0;
//		if(accounts.isEmpty())
//			return 0;
//		long max=accounts.get(0).getAccNumber();
//		for(IAccount acc:accounts){
//			if(acc.getAccNumber()>max)
//				max=acc.getAccNumber();
//		} 
//		
//		return 4;
		
	}

	public static void addInterest() {
		for(IAccount account: accounts) {
			account.addInterest();
		}
	}

	public static List<IAccount> getAllAccounts() {
		return accounts;
	}

	public static List<ICustomer> getCustomers() {
		return customers;
	}

	public static IAccount searchAccount(Long acctNo) {
		
		for (IAccount iAccount : accounts) {
			
			if( iAccount.getAccNumber() == acctNo )
				return  iAccount;
		}
		
		return null;
	}

}
