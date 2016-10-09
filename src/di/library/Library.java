package di.library;

import com.google.inject.Guice;
import com.google.inject.Injector;

import di.frwk.Koin;

public class Library extends Koin {

	@Override
	protected void init() {
		title = "MUM COMPRO LIBRARY";
		rootDir = "di.library";
		
	}


	@Override
    public String[] getColumns(){	
		return new String[]{"ISBN ","Title ", "Author ","Publisher","No. Copies","Borrowed Date","Price "};
	}
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new LibConfig());
		Koin lib = injector.getInstance(Koin.class);
		lib.start();
	}
}
