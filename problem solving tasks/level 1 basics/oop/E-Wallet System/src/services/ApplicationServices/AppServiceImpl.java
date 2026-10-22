package services.ApplicationServices;

import modules.AccountsBuilder;
import modules.WalletSystem;
import services.AccountServices.AccountServiceImpl;
import Validtion.ValidationUtils;

import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;

public  class AppServiceImpl implements AppService {
    String  userName;
    String  password;
    String  phoneNumber;
    float   age;
    Scanner scanner= new Scanner(System.in);
    AccountServiceImpl accountService=new AccountServiceImpl();
    AccountsBuilder account;

    /** Displays the application menu and routes the selected operation. */
    @Override
    public void start() {

        System.out.print("Wellcome To"+ WalletSystem.name +"\n");
        int counter=1;
        while (counter<=3){
            System.out.print("------>  Choose  Number  Refer To Your Operation  <----------\n ");
            System.out.print("1--> Login    2--> Register   3--> Exist  \n ");
            try {
                int enterNumber = readInteger("", value -> value >= 1 && value <= 3,
                        "Enter a number from 1 to 3.");
                switch (enterNumber){
                    case 1:
                        Login();
                        break;
                    case 2:
                        rigister();
                        break;
                    case 3:
                        System.out.print( WalletSystem.name + "  wishes you the best\n");
                        break;
                    default:
                        System.out.print( "Your choose is not Exist Try Again Later :( \n");
                        if(counter<3) {System.out.println("Remaining attempts: " + (3 - counter)+"\n");}
                        counter++;
                        break;

                }
            }
            catch (RuntimeException exception) {
                System.out.println("Unable to process that choice. Please try again.");
                counter++;
            }

        }


    }

    /** Collects new account details and creates an account. */
    private void rigister() {
        System.out.print("Wellcome To Register Page \n");

        System.out.print("Enter Your UserName : \n");
        userName = readInput("Enter Your UserName : \n", ValidationUtils::isUserNameValid,
                "Username must contain alphabetic names of 3 to 10 letters.");

        password = readInput("Enter Your Password : \n", ValidationUtils::isPasswordValid,
                "Password needs 8 or more characters, an uppercase letter, a digit, and a special character.");

        phoneNumber = readInput("Enter Your Number : \n", ValidationUtils::isPhoneNumberValid,
                "Enter a valid Egyptian mobile number.");
        age = readFloat("Enter Your Age : \n", ValidationUtils::isAgeValid,
                "Age must be between 15 and 75.");
        String dateOfCreation = String.valueOf(new Date());

        AccountsBuilder account= new AccountsBuilder(userName,password,phoneNumber,dateOfCreation,true,age);
        AccountsBuilder ResposeCreateAcc= accountService.createAccount(account);

        if(ResposeCreateAcc==null){
            System.out.print("Account is Already Exist ..............\n");
        }
        else{
            System.out.print("Account Created Successfully..............\n");
            Login();

        }
    }

    /** Prompts for credentials and opens the account page after successful login. */
    private void Login() {
        System.out.print("Wellcome To Login Page \n");

        userName = readInput("Enter Your UserName : \n", ValidationUtils::isUserNameValid,
                "Username must contain alphabetic names of 3 to 10 letters.");

        System.out.print("Enter Your Password : \n");
        password = scanner.next();

        account= new AccountsBuilder(userName,password);
        AccountsBuilder getAccountByUserName= accountService.getAccountByUserName(account);
         if(getAccountByUserName==null){
             System.out.print("Account is not Exist .");
         }
         else{
             System.out.print("Wellcome to Your Account ......\n");
             mainPage(getAccountByUserName);
         }
    }

    /** Displays account operations and routes the selected operation. */
    private  void mainPage( AccountsBuilder account){
        System.out.print("Wellcome   "+account.getUserName()+"   To Home Page \n");
        System.out.print("What do you want to  do   "+account.getUserName()+"  ? \n");
        System.out.print(
                        """
                        1---> Deposit           2---> Withdraw
                        
                        3---> Transfer          4---> Show account details
                        
                        5---> Change password   6---> Logout
                        """);
        int operationNumber = readInteger("", value -> value >= 1 && value <= 6,
                "Choose an operation from 1 to 6.");
        switch (operationNumber){
            case 1:
                depositMoney(account);
                break;
            case 2:
                withdrawMoney(account);
                break;
            case 3:
                transferMoney(account);
                break;
            case 4:
                showAccount(account);
                break;
            case 5:
                changePassword(account);

                break;
            case 6:
                System.out.print("We wish you a good experience. ? \n");
                start();
                break;

        }


    }

    /** Changes the account password after the new password is confirmed. */
    private  void changePassword(AccountsBuilder account){
        System.out.print("-----------------------------------------------------\n");
        System.out.print("change Password Page ..... \n");
        System.out.print("-----------------------------------------------------\n");


//        System.out.print("Enter Current Password ..... \n");
//        String Password=scanner.next();
        System.out.print("Enter New Password ..... \n");
        String newPassword = readInput("", ValidationUtils::isPasswordValid,
                "Password needs 8 or more characters, an uppercase letter, a digit, and a special character.");
        System.out.print("Enter New Password ..... \n");
        String RePassword=scanner.next();

        if(newPassword.equals(RePassword)){
            accountService.changePassword(account,newPassword);
            System.out.print("Password  changed Successfully..... \n");
            start();

        }else{
            changePassword( account);
        }


    }

    /** Displays the account's profile and balance details. */
    private  void showAccount(AccountsBuilder account){
        System.out.print("-----------------------------------------------------\n");
        System.out.print("Show Account Details  Page ..... \n");
        System.out.print("-----------------------------------------------------\n");

        System.out.print("User Name     -----> "+account.getUserName()+"\n");
        System.out.print("Phone Number   -----> "+account.getPhoneNumber()+"\n");
        System.out.print("Age   -----> "+account.getAge()+"\n");
        System.out.print("Balance  -----> "+account.getBalance()+"\n");
        System.out.print("Date of Creation Account---------> "+account.getDateOfCreation()+"\n");

         mainPage(account);


    }

    /** Prompts for a positive amount and deposits it into the account. */
    private  void depositMoney(AccountsBuilder account){

        System.out.print("-----------------------------------------------------\n");
        System.out.print("Deposit Page ..... \n");
        System.out.print("-----------------------------------------------------\n");
        System.out.print("The amount of money to be deposited ..... \n");
        int amountOfMoney = readInteger("", value -> value > 0 && ValidationUtils.isBalanceValid(value),
                "Enter an amount greater than zero.");
        if(amountOfMoney>0){
            accountService.chaneBalance(account,amountOfMoney,"Deposit");
            System.out.print("-----------   Deposit Successfully     ------------\n");
            System.out.print(" Your Balance    ---->"+account.getBalance()+"\n");
            mainPage(account);
        }
        else{
            depositMoney(account);
        }


    }

    /** Prompts for a valid amount and withdraws it from the account. */
    private  void withdrawMoney(AccountsBuilder account){

        System.out.print("-----------------------------------------------------\n");
        System.out.print("Withdraw Page ..... \n");
        System.out.print("-----------------------------------------------------\n");
        System.out.print("The amount of money to be Withdraied ..... \n");
        int amountOfMoney = readInteger("", value -> value > 0 && value <= account.getBalance(),
                "Enter an amount greater than zero and no more than your balance.");
        if(amountOfMoney>0&&amountOfMoney<=account.getBalance()){
            accountService.chaneBalance(account,amountOfMoney,"Withdraw");
            System.out.print("-----------   Withdraw Successfully     ------------\n");
            System.out.print(" Your Balance      ----->"+account.getBalance()+"\n");
            mainPage(account);
        }
        else{
            withdrawMoney(account);
        }


    }

    /** Transfers a specified amount from the account to another user's account. */
    private  void transferMoney(AccountsBuilder account){
        System.out.print("-----------------------------------------------------\n");
        System.out.print("Transfer Page ..... \n");
        System.out.print("-----------------------------------------------------\n");
        System.out.print("The amount of money to be Transfer ..... \n");
        int amountOfMoney = readInteger("", value -> value > 0 && value <= account.getBalance(),
                "Enter an amount greater than zero and no more than your balance.");
        System.out.print("The username you want to transfer to  ..... \n");
        String userNameOfTransfer = readInput("", ValidationUtils::isUserNameValid,
                "Enter a valid username.");
        String existUser=accountService.getAccountByUserName(account).getUserName();
        AccountsBuilder transferAccount=accountService.getAccountByUserName(userNameOfTransfer);

        if(existUser.equals(userNameOfTransfer)){
            System.out.print("Can Not Tranfer between same Account ");
            transferMoney(account);

        }
        else if (transferAccount!=null&&account.getBalance()>=amountOfMoney){
            accountService.chaneBalance(transferAccount,amountOfMoney,"Deposit");
            accountService.chaneBalance(account,amountOfMoney,"Withdraw");
            System.out.print("-----------   Transfer  Successfully     ------------\n");
            System.out.print(" Your Balance    ---->   "+account.getBalance()+"\n");
        }else {
            System.out.print("Account is not exist try again.....  ");
            transferMoney(account);
        }
    }

    /** Reads tokens until one passes the supplied validation rule. */
    private String readInput(String prompt, Predicate<String> validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (validator.test(input)) {
                return input;
            }
            System.out.println(errorMessage);
        }
    }

    /** Reads an integer that satisfies the supplied validation rule. */
    private int readInteger(String prompt, Predicate<Integer> validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            try {
                int value = Integer.parseInt(input);
                if (validator.test(value)) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Show the common validation message below.
            }
            System.out.println(errorMessage);
        }
    }

    /** Reads an age that satisfies the account age rules. */
    private float readFloat(String prompt, Predicate<Float> validator, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            try {
                float value = Float.parseFloat(input);
                if (validator.test(value)) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Show the common validation message below.
            }
            System.out.println(errorMessage);
        }
    }
}
