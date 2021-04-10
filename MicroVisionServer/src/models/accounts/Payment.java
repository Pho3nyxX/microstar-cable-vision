package models.accounts;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment extends _Payment {

    /**
     *
     */
    private static final long serialVersionUID = 6685701012871465008L;

    public Payment(int paymentID, double amount, String paymentStatus, LocalDate paymentDueDate, int accountID) {
        super(paymentID, amount, paymentStatus, paymentDueDate, accountID);
    }

    public Payment() {
        super();
    }
    
}
