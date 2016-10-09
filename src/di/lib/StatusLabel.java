package di.lib;

public interface StatusLabel {
    
    public String getDescription(); 
}

class PlainStatusLabel implements StatusLabel {
   
    public String getDescription() {
        return "Create and Process Personal Account";
    }
}
