package di.lib;


abstract class LblDecorator implements StatusLabel {
    protected StatusLabel lblToBeDecorated; 

    public LblDecorator (StatusLabel lblToBeDecorated) {
        this.lblToBeDecorated = lblToBeDecorated;
    }
   
    public String getDescription() {
        return lblToBeDecorated.getDescription(); 
    }
}

class LblMessageDecorator extends LblDecorator {
    public LblMessageDecorator (StatusLabel lblToBeDecorated) {
        super(lblToBeDecorated);
    }

    @Override
    public String getDescription() {
        String str = "<html><b><font color=blue size=+4>"+super.getDescription()+"</font><b></html>";
        
        return str;
    }
}

