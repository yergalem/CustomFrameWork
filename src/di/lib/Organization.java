package di.lib;

import java.util.List;

import com.google.inject.Inject;

public class Organization extends Customer implements IOrganization {

	@Inject
	public Organization(){
		
	}
	public Organization(int numberOfEmployees, String name, String email, IAddress address,
			List<IAccount> accounts, boolean isActive) {
		super(name, email, address, accounts, isActive);
		this.numberOfEmployees = numberOfEmployees;
	}

	private int numberOfEmployees;

	@Override
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	@Override
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public void sendEmail(IEntry entry) {
		System.out.println("Email sent to " + this.getEmail());
	}

	@Override
	public String getType() {
		return "C";
	}
}