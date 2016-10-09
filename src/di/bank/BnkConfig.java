package di.bank;

import com.google.inject.AbstractModule;

import di.frwk.Koin;

public class BnkConfig extends AbstractModule {

  @Override
  protected void configure() {
    bind(Koin.class).to(di.bank.Bank.class);
  }
}