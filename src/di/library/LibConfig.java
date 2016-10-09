package di.library;

import com.google.inject.AbstractModule;

import di.frwk.Koin;

public class LibConfig extends AbstractModule {

  @Override
  protected void configure() {
    bind(Koin.class).to(di.library.Library.class);
  }
}