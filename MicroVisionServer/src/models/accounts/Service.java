package models.accounts;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Service extends _Service{
    @OneToMany
    @JoinColumn(name = "service_id", referencedColumnName="service_id")
    protected List<Bill> service;
}
