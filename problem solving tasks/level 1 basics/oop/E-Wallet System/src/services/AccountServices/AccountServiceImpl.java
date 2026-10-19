package services.AccountServices;

import modules.AccountsBuilder;
import modules.WalletSystem;

import java.util.Optional;

public class AccountServiceImpl implements Accountservices{
    private  WalletSystem walletSystem=new WalletSystem();
    @Override
    public AccountsBuilder createAccount(AccountsBuilder account) {
        boolean isExistAccount= walletSystem.getAccounts().stream().anyMatch(acc->acc.getUserName().equals(account.getUserName()));
        if(isExistAccount){
            return null;
        }
        else{
            walletSystem.getAccounts().add(account);
            return account;

        }

    }
    public AccountsBuilder getAccountByUserName(AccountsBuilder account) {
        Optional<AccountsBuilder> existAccount =
                walletSystem.getAccounts()
                        .stream()
                        .filter(acc ->
                                acc.getUserName().equals(account.getUserName())
                                        && acc.getPassword().equals(account.getPassword())
                        )
                        .findFirst();

        if (existAccount.isPresent()) {
            return existAccount.get();
        } else {
            return null;
        }

    }

    @Override
    public String changePassword(AccountsBuilder account, String newPassword) {
        Optional<AccountsBuilder> existAccount =
                walletSystem.getAccounts()
                        .stream()
                        .filter(acc ->
                                acc.getUserName().equals(account.getUserName())
                                        && acc.getPassword().equals(account.getPassword()) ).findFirst();
        if (existAccount.isPresent()) {
            AccountsBuilder acc = existAccount.get();
            acc.setPassword(newPassword);
           return "Password Changed Successfly";
        }
        else{
            return "Password is not Change ";

        }



    }

    @Override
    public double chaneBalance(AccountsBuilder account,double balance,String tybeOperation) {
        Optional<AccountsBuilder> existAccount =
                walletSystem.getAccounts()
                        .stream()
                        .filter(acc ->
                                acc.getUserName().equals(account.getUserName())
                                        && acc.getPassword().equals(account.getPassword()) ).findFirst();
        if (existAccount.isPresent()&&tybeOperation.equals("Withdraw")) {
            AccountsBuilder acc = existAccount.get();
            acc.setBalance(acc.getBalance()-balance);

            return acc.getBalance();

        }
        else if (existAccount.isPresent()&&tybeOperation.equals("Deposit")){
            AccountsBuilder acc = existAccount.get();
            acc.setBalance(acc.getBalance()+balance);

            return acc.getBalance();


        }
        else return 0.0;
    }

    @Override
    public AccountsBuilder getAccountByUserName(String username) {
        Optional<AccountsBuilder>TransferAccount=walletSystem.getAccounts().stream().filter(acc->acc.getUserName().equals(username)).findFirst();

        if (TransferAccount.isPresent()){
            return TransferAccount.get();
        }else{
            return null;
        }
    }



}
