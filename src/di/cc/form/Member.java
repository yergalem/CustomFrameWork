
package di.cc.form;

import di.frwk.Empty;
import di.frwk.Number;
import di.frwk.Required;
import di.frwk.UserModel;

public class Member extends UserModel {
    
    @Required(name="username", value="Username is Required")
    String username;
    
    @Empty(name="password", value="Password can't be Empty")
    String pwd;
    
    @Empty(name="firstname", value="Firstname can't be Empty")
    @Required(name="firstname", value="Firstname is Required")
    String fname;
    
    @Empty(name="lastname", value="Lastname can't be Empty")
    @Required( name="lastname", value="Lastname is Required")   
    @Number( name="lastname", value="Lastname should be Number")  
    String lname;
    
    @Empty(name="gender", value="Gender can't be Empty")
    @Required( name="gender", value="Gender is Required")
    String gender;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String password) {
        this.pwd = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
   
    
}
