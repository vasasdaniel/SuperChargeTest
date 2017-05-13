/**
 * Handles the scenario of the banking system.
 */
public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
        Account c1 = m.createAccount("Customer1", 3500.0);
        Account c2 = m.createAccount("Customer2", 4500.0);
        Account c3 = m.createAccount("Customer3", 5500.0);

        c1.deposit(300.0);
        c2.deposit(100.0);
        c1.withdraw(200.0);
        c3.withdraw(1000.0);

        c1.transfer("Customer2", 200.0);
        c1.getHistory();
        c1.getHistoryFiltered("2017.05.02", "2017.05.14", transactionType.DEPOSIT);

        c2.transfer("Customer1", 150.0);
        c2.getHistory();
        c2.getHistoryFiltered("2017.05.02", "2017.05.14", transactionType.DEPOSIT);

        c3.getHistory();
    }
}
