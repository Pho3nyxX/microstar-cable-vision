package models.users;

public class Address extends _Address {
    private static final long serialVersionUID = -7106330856758620678L;

    /**-----------------------------CONSTRUCTORS-------------------------------- */
    // default constructor
    public Address() {
        super();
    }
    public Address(int address_id, String parish, String town, String street, int customer_id) {
        super(address_id, parish, town, street, customer_id);
    }

    public Address(String parish, String town, String street) {
        super();
        this.setParish(parish);
        this.setTown(town);
        this.setStreet(street);
    }


}
