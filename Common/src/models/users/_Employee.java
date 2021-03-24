package models.users;

import java.io.Serializable;

import javax.persistence.*;


// Annotations
@Entity
@Table(name = "employee")
public abstract class _Employee extends _User implements Serializable {

    // @id
    // @GeneratedValue(strategy=GenerationType.IDENTITY)
    // @Column(name="emp_id")

    @Column(name="role")
    String role;

    @Column(name="status")
    String status;

    // default constructor
    public _Employee() {
        super();
        this.role = "";
        this.status = "";
    }

    // primary constructor
    public _Employee(int userID, String firstName, String lastName, String middleName, String password, int age,
            String gender, String role, String status) {
        super(userID, firstName, lastName, middleName, password, age, gender);
        this.role = role;
        this.status = status;
    }

    // copy constructor
    public _Employee(_Employee employee) {
        super(
            employee.getUserID(),
            employee.getfirstName(),
            employee.getlastName(),
            employee.getmiddleName(),
            employee.getPassword(),
            employee.getAge(),
            employee.getGender()
        );
        this.role = employee.role;
        this.status = employee.status;
    }

    // getters & setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee [role=" + role + ", status=" + status + "]";
    }

}
