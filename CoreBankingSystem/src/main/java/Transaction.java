/**
 * Helper class to store information about transactions
 */
enum transactionType {
    WITHDRAW,
    DEPOSIT
};

public class Transaction {
    String sender;
    String receiver;
    Double ammount;
    transactionType trType;


    /**
     * Paramteres constructor for creating new Transaction
     *
     * @param _sender   The name of the customer who sending money
     * @param _receiver The name of the customer who receiving meony
     * @param _trType   Transaction type: WITHDRAW/DEPOSIT
     * @param _ammount  The ammount of the money to transfer
     */
    public Transaction(String _sender, String _receiver, transactionType _trType, double _ammount) {
        sender = _sender;
        receiver = _receiver;
        trType = _trType;
        ammount = _ammount;
    }

}
