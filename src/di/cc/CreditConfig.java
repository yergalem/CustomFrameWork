package di.cc;

import com.google.inject.AbstractModule;

import di.frwk.Koin;

public class CreditConfig extends AbstractModule {

  @Override
  protected void configure() {
    bind(Koin.class).to(di.cc.CCard.class);
  }
}