package bank_system;

import java.util.List;

/**
 * Lớp đại diện cho ngân hàng quản lý khách hàng.
 */
public class Bank {
  private List<Customer> customerList;

  public List<Customer> getCustomerList() {
    return customerList;
  }
}