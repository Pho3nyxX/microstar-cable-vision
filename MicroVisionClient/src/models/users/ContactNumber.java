package models.users;

public class ContactNumber extends _ContactNumber{
     /**
     *
     */
    private static final long serialVersionUID = 7526981870015571890L;

    public ContactNumber(String contactNum, int userId) {
        super(contactNum, userId);
    }

    public ContactNumber() {
        super();
    }
}
