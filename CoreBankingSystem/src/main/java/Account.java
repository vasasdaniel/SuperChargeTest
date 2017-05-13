import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Store the infomarmation about the customer. Handles money transactions, logging and history printing.
 */

public class Account {

    private double balance = 0.0;
    private String customerName = "";
    private Date creationDate = new Date();
    private Manager man = new Manager();
    HashMap<Date, Transaction> log = new HashMap<Date, Transaction>();

    /**
     * Account constructor with the customer name and the initial balance of the customer
     *
     * @param name
     * @param initBalance
     */
    Account(String name, double initBalance) {
        balance = initBalance;
        customerName = name;
        System.out.println("Bank account created on " + creationDate + " with a name of " + customerName);
    }

    /**
     * Withdraw money from the customer account. Also checks that the required money is available on the account.
     * Every trsansaction is logged.
     *
     * @param ammount
     */
    public void withdraw(double ammount) {
        if (ammount > balance) {
            System.out.println("Not enoguh money on your bank account!");
        } else {
            balance -= ammount;
            log.put(new Date(), new Transaction(this.customerName, this.customerName, transactionType.WITHDRAW, ammount));
            System.out.println(customerName + "-> " + ammount + " of money has been added to your balance. \n" +
                    customerName + "-> Your new account balance is: " + balance);
        }
    }

    /**
     * Deposit money from the customer account.
     * Every trsansaction is logged.
     *
     * @param ammount
     */
    public void deposit(double ammount) {
        balance += ammount;
        log.put(new Date(), new Transaction(this.customerName, this.customerName, transactionType.DEPOSIT, ammount));
        System.out.println(customerName + "-> Your new account balance is: " + balance);
    }

    /**
     * Handle the money transfer transaction. Transfer operation can be only deposit.
     *
     * @param ammount
     */
    public void receiveMoney(double ammount) {
        this.deposit(ammount);
        System.out.println(customerName + " has received " + ammount + " ammount of money.");
    }

    /**
     * Handle money transfertation from bank accounts.
     * Every transfer is logged.
     *
     * @param destination
     * @param ammount
     */
    public void transfer(String destination, double ammount) {

        Account destinationAccount = man.findCustomer(destination);

        destinationAccount.receiveMoney(ammount);

        Transaction t = new Transaction(this.customerName, destination, transactionType.DEPOSIT, ammount);
        log.put(new Date(), t);
    }

    /**
     * Prints every transaction on the instance from the log.
     */
    public void getHistory() {
        for (Map.Entry<Date, Transaction> entry : log.entrySet()) {
            Date key = entry.getKey();
            Transaction value = entry.getValue();
            System.out.println("Date:" + key + " | sender: " + value.sender + " | receiver: " + value.receiver + " | ammout:" + value.ammount);

        }
    }

    /**
     * Prints filtered transaction on the instance from the log.
     *
     * @param after  : Date after transaction
     * @param before : Date before transaction
     * @param trType : Transaction type
     */

    public void getHistoryFiltered(String after, String before, transactionType trType) {

        DateFormat format = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
        Date dateBefore = new Date();
        Date dateAfter = new Date();
        Date formattedTime = new Date();
        try {
            dateBefore = format.parse(before);
            dateAfter = format.parse(after);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Date, Transaction> entry : log.entrySet()) {
            Date key = entry.getKey();
            Transaction value = entry.getValue();

            if (key.before(dateBefore) && key.after(dateAfter)) {
                if (value.trType == trType) {
                    System.out.println("Date: " + key + " | sender: " + value.sender + " | receiver: " + value.receiver + " | type: " + value.trType.toString() + " | ammout:" + value.ammount);
                }
            }


        }
    }
}
