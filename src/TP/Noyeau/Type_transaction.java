package TP.Noyeau;

public class Type_transaction extends Critere {
    private Transaction transaction;

    public Type_transaction(Transaction t){
        this.transaction = t;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
