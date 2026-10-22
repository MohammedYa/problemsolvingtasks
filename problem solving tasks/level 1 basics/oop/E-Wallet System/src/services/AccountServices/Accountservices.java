package services.AccountServices;

import modules.AccountsBuilder;

public interface Accountservices {
    /** Creates and stores a wallet account using the supplied account details. */
    AccountsBuilder createAccount(AccountsBuilder account);

    /** Finds an account using the username in the supplied account object. */
    AccountsBuilder getAccountByUserName(AccountsBuilder account);

    /** Changes the account password and returns the result message. */
    String changePassword(AccountsBuilder account,String newPassword);

    /** Applies the requested balance operation and returns the resulting balance. */
    double  chaneBalance(AccountsBuilder account,double balance,String tybeOfOperation);

    /** Finds and returns an account by username. */
    AccountsBuilder getAccountByUserName(String username);

}
