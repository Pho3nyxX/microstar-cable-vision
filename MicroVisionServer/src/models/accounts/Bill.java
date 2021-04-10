package models.accounts;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "bill")
public class Bill extends _Bill{

    /**
     *
     */
    private static final long serialVersionUID = 3075504526132439913L;

    public Bill(int billID, LocalDate date, LocalDate periodStart, LocalDate periodEnd, double amount, LocalDate due,
            int serviceID) {
        super(billID, date, periodStart, periodEnd, amount, due, serviceID);
    }

    public Bill() {
        super();
    }
    
}
