package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tài khoản vãng lai.
 */
public class CheckingAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);

  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  protected void doDepositing(double amount) throws BankException {
    // Logic nạp tiền thực tế
  }

  @Override
  protected void doWithdrawing(double amount) throws BankException {
    // Logic rút tiền thực tế
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(
          Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance, finalBalance);
      addTransaction(t);
    } catch (BankException e) {
      logger.error("Lỗi giao dịch nạp tiền vãng lai: {}", e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(
          Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance, finalBalance);
      addTransaction(t);
    } catch (BankException e) {
      logger.error("Lỗi giao dịch rút tiền vãng lai: {}", e.getMessage());
    }
  }
}