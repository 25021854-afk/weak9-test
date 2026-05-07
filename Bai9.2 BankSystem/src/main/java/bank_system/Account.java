package bank_system;

import java.util.ArrayList;
import java.util.List;

/** 
 * Lớp đại diện cho tài khoản ngân hàng.
 */
public abstract class Account {
  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  private long accountNumber;
  private double balance;
  protected List<Transaction> list;

  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.list = new ArrayList<>();
  }

  public long getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public void addTransaction(Transaction t) {
    list.add(t);
  }

  public abstract void deposit(double amount);
  public abstract void withdraw(double amount);
  protected abstract void doDepositing(double amount) throws BankException;
  protected abstract void doWithdrawing(double amount) throws BankException;
}