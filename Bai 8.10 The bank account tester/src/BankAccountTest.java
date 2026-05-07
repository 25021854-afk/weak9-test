public class BankAccountTest {
    public static void main(String[] args) {
        System.out.println("=== Bat dau chay BankAccountTest ===");

        // 1. Test Deposit & Withdraw (EP & BVA)
        testDepositAndWithdraw();

        // 2. Test tinh nhat quan (Sequence Test)
        double finalBalance = testConsistency();
        System.out.println("So du cuoi cung: " + finalBalance);
        //Cập nhật để lấy số dư cuối cùng

        System.out.println("=== Tat ca test PASS ===");
    }

    private static void testDepositAndWithdraw() {
        BankAccount account = new BankAccount("123", "User", 500.0);

        // Deposit test
        account.deposit(100.0);
        check(600.0, account.getBalance(), "Deposit hop le");

        boolean caught = false;
        try { account.deposit(0.0); } catch (IllegalArgumentException e) { caught = true; }
        if (!caught) throw new RuntimeException("FAIL: Deposit 0 khong nem loi");

        // Withdraw test
        account.withdraw(500.0);
        check(100.0, account.getBalance(), "Withdraw hop le");

        if (account.withdraw(600.0)) throw new RuntimeException("FAIL: Rut qua so du");
    }

    //Thay đổi kiểu trả về từ void sang double
    private static double testConsistency() {
        BankAccount acc = new BankAccount("999", "User", 0.0);
        
        acc.deposit(500.0);
        if (!acc.withdraw(200.0)) throw new RuntimeException("FAIL: Rut 200 that bai");
        if (acc.withdraw(400.0)) throw new RuntimeException("FAIL: Rut 400 van thanh cong");
        
        check(300.0, acc.getBalance(), "Kiem tra so du cuoi");
        return acc.getBalance(); //Trả về số dư
    }

    private static void check(double expected, double actual, String msg) {
        if (Math.abs(expected - actual) > 0.001) {
            throw new RuntimeException("FAIL: " + msg + ". Mong doi " + expected + " nhan " + actual);
        }
    }
}