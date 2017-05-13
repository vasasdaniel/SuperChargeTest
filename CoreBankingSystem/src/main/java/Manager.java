import java.util.HashMap;

/**
 * Handles the account creations and stores them after creating.
 */
public class Manager {

    private static HashMap<String, Account> accounts = new HashMap<String, Account>();

    /**
     * Create a new Account instance with the given paramters
     *
     * @param name        Customer name
     * @param initBalance The initial balance of the account
     * @return
     */
    public Account createAccount(String name, double initBalance) {
        //TODO initbalance check is >0
        Account a = new Account(name, initBalance);
        accounts.put(name, a);
        return a;
    }

    /**
     * Find the customer in the accounts HashMap. If the given name is not in there, throws exception
     *
     * @param name Customer name
     * @return
     */
    Account findCustomer(String name) {
        try {
            if (accounts.containsKey(name)) {
                return accounts.get(name);
            }
        } catch (Exception e) {
            System.out.println("The given name cannot find in the customer list!");
        }
        return null;
    }
}
