package services.ApplicationServices;

import modules.AccountsBuilder;
import modules.WalletSystem;
import services.AccountServices.AccountServiceImpl;

import java.util.Date;
import java.util.Scanner;

public  class AppServiceImpl implements AppService {
    String  userName;
    String  password;
    String  phoneNumber;
    float   age;
    Scanner scanner= new Scanner(System.in);
    AccountServiceImpl accountService=new AccountServiceImpl();
    AccountsBuilder account;
    @Override
    public void start() {

        System.out.print("Wellcome To"+ WalletSystem.name +"\n");
        int counter=1;
        while (counter<=3){
            System.out.print("------>  Choose  Number  Refer To Your Operation  <----------\n ");
            System.out.print("1--> Login    2--> Register   3--> Exist  \n ");
            try {
                int enterNumber= scanner.nextInt();
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
            catch (Throwable throwable){
                scanner.nextLine();

                System.out.print(" You Should Enter the Invalid Number  from 1 to 3 \n");

                if(counter>=3) {System.out.println("You have exceeded the maximum attempts!\n");}
                else{
                    System.out.println("Remaining attempts: " + (3 - counter)+"\n");

                }
                counter++;
            }

        }


    }

    private void rigister() {
        System.out.print("Wellcome To Register Page \n");

        System.out.print("Enter Your UserName : \n");
        userName = scanner.next();

        System.out.print("Enter Your  Password : \n");
        password = scanner.next();

        System.out.print("Enter Your  Number : \n");
        phoneNumber =scanner.next() ;
        System.out.print("Enter Your  Age : \n");
        age =scanner.nextFloat() ;
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

    private void Login() {
        System.out.print("Wellcome To Login Page \n");

        System.out.print("Enter Your UserName : \n");
        userName = scanner.next();

        System.out.print("Enter Your  Password : \n");
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

    private  void mainPage( AccountsBuilder account){
        System.out.print("Wellcome   "+account.getUserName()+"   To Home Page \n");
        System.out.print("What do you want to  do   "+account.getUserName()+"  ? \n");
        System.out.print(
                        """
                        1---> Deposit           2---> Withdraw
                        
                        3---> Transfer          4---> Show account details
                        
                        5---> Change password   6---> Logout
                        """);
        int operationNumber = scanner.nextInt();
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
    private  void changePassword(AccountsBuilder account){
        System.out.print("-----------------------------------------------------\n");
        System.out.print("change Password Page ..... \n");
        System.out.print("-----------------------------------------------------\n");


//        System.out.print("Enter Current Password ..... \n");
//        String Password=scanner.next();
        System.out.print("Enter New Password ..... \n");
        String newPassword=scanner.next();
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
    private  void depositMoney(AccountsBuilder account){

        System.out.print("-----------------------------------------------------\n");
        System.out.print("Deposit Page ..... \n");
        System.out.print("-----------------------------------------------------\n");
        System.out.print("The amount of money to be deposited ..... \n");
        int amountOfMoney = scanner.nextInt();
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
    private  void withdrawMoney(AccountsBuilder account){

        System.out.print("-----------------------------------------------------\n");
        System.out.print("Withdraw Page ..... \n");
        System.out.print("-----------------------------------------------------\n");
        System.out.print("The amount of money to be Withdraied ..... \n");
        int amountOfMoney = scanner.nextInt();
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
    private  void transferMoney(AccountsBuilder account){
        System.out.print("-----------------------------------------------------\n");
        System.out.print("Transfer Page ..... \n");
        System.out.print("-----------------------------------------------------\n");
        System.out.print("The amount of money to be Transfer ..... \n");
        int amountOfMoney = scanner.nextInt();
        System.out.print("The username you want to transfer to  ..... \n");
        String userNameOfTransfer=scanner.next();
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
}
