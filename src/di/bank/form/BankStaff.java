package di.bank.form;

import di.frwk.Empty;
import di.frwk.Required;
import di.frwk.UserModel;
import di.frwk.Number;

public class BankStaff extends UserModel{

    @Required(name = "username", value = "Username is Required")
    String username;

    @Required(name = "password", value = "Password is Required")
    String pwd;

    @Empty(name = "age", value = "Age can't be Empty")
    @Number(name = "age", value = "Age should be Number")     
    int age;

    @Empty(name = "firstname", value = "Firstname can't be Empty")
    @Required(name = "firstname", value = "Firstname is Required")
    String fname;

    @Empty(name = "lastname", value = "Lastname can't be Empty")
    //@Required( name="lastname", value="Lastname is Required")   
    String lname;

    @Empty(name = "gender", value = "Gender can't be Empty")
    @Required(name = "gender", value = "Gender is Required")
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
