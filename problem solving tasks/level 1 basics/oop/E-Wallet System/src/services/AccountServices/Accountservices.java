package services.AccountServices;

import modules.AccountsBuilder;

public interface Accountservices {
    AccountsBuilder createAccount(AccountsBuilder account);
    AccountsBuilder getAccountByUserName(AccountsBuilder account);
    String changePassword(AccountsBuilder account,String newPassword);
    double  chaneBalance(AccountsBuilder account,double balance,String tybeOfOperation);
    AccountsBuilder getAccountByUserName(String username);

}
