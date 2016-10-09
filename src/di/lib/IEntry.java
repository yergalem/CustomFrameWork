package di.lib;

import java.time.LocalDate;

import di.lib.IAccount;

public interface IEntry {

	LocalDate getDate();

	double getAmount();

	void setAmount(double amount);

	void setAccount(IAccount account);

	IAccount getAccount();

}