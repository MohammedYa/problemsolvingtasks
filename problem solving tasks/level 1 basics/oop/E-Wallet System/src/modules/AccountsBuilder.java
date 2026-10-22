package modules;

/** Stores the profile, credentials, and balance details for a wallet account. */
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

    /** Creates a complete account with an initial balance of zero. */
    public AccountsBuilder(String userName, String password, String phoneNumber, String dateOfCreation, boolean active, float age){
        setUserName(userName);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setActive(active);
        setDateOfCreation(dateOfCreation);
        this.balance=0.0;
        setAge(age);

    }
    /** Creates an account object containing login credentials. */
    public AccountsBuilder(String userName, String password){
        setUserName(userName);
        setPassword(password);
    }
    /** Creates an account object containing only a username. */
    public AccountsBuilder(String userName){
       setUserName(userName);
    }
    /** Sets the account username. */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /** Sets the account phone number. */
    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
    /** Sets the account password. */
    public void setPassword(String password) {
        this.password = password;
    }
    /** Sets the account creation date. */
    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
    /** Sets whether the account is active. */
    public void setActive(boolean active) {
        this.active = active;
    }
    /** Sets the account holder's age. */
    public void setAge(float age) {
        this.age = age;
    }
    /** Sets the account balance. */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /** Returns the account username. */
    public String getUserName() {
        return userName;
    }
    /** Returns the account password. */
    public String getPassword() {
        return password;
    }
    /** Returns the account phone number. */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /** Returns the account creation date. */
    public String getDateOfCreation() {
        return dateOfCreation;
    }
    /** Returns the current account balance. */
    public double getBalance() {
        return balance;
    }
    /** Returns whether the account is active. */
    public boolean isActive() {
        return active;
    }
    /** Returns the account holder's age. */
    public float getAge() {
        return age;
    }
}
