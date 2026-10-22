package modules;
import java.util.ArrayList;
import java.util.Scanner;


/** Holds the wallet system's name and registered accounts. */
public class WalletSystem {

/** Display name used by the application. */
public static final String   name ="EGY-Wallet";
private ArrayList<AccountsBuilder> accounts=new ArrayList<>();

/** Replaces the list of accounts managed by the wallet system. */
public void setAccounts(ArrayList<AccountsBuilder> accounts) {
    this.accounts = accounts;
}

/** Returns the accounts managed by the wallet system. */
public ArrayList<AccountsBuilder> getAccounts() {
    return accounts;
}

















}
