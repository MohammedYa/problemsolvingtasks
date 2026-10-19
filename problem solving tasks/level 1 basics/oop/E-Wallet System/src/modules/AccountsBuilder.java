package modules;

public class AccountsBuilder {

    // AccountsBuilder Attributes

    private  String userName;
    private  String password;
    private  String phoneNumber;
    private  double balance;
    private  String dateOfCreation;
    private  boolean active;
    private  float age;

    // AccountsBuilder constructor

    public AccountsBuilder(String userName, String password, String phoneNumber, String dateOfCreation, boolean active, float age){
        setUserName(userName);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setActive(active);
        setDateOfCreation(dateOfCreation);
        this.balance=0.0;
        setAge(age);

    }
    public AccountsBuilder(String userName, String password){
        setUserName(userName);
        setPassword(password);
    }
    public AccountsBuilder(String userName){
       setUserName(userName);
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setAge(float age) {
        this.age = age;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getDateOfCreation() {
        return dateOfCreation;
    }
    public double getBalance() {
        return balance;
    }
    public boolean isActive() {
        return active;
    }
    public float getAge() {
        return age;
    }
}