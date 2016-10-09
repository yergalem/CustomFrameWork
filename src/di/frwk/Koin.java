package di.frwk;

import com.google.inject.Inject;

import di.lib.Window;

abstract public class Koin {
	protected String title;
	protected String rootDir;
	private static Koin app;    
	
	protected abstract void init();

	public final void start() {
		init();
		new Window().display(this.app.title);

	}

	@Inject
  	public void setApp(Koin coin) {		
  		app = coin;
  	}

	public static Koin getActiveApp() {
		return app;
	}

	public String[] getColumns() {
		return null;
	}

	public String getTitle() {
		return title;
	}
	
	
}
