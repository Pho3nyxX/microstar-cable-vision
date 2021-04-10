package models.accounts;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service extends _Service{
    /**
     *
     */
    private static final long serialVersionUID = -5707531268648422965L;

    @OneToMany
    @JoinColumn(name = "service_id", referencedColumnName="service_id")
    protected List<Bill> service;

}
