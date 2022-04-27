package org.example.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vacationdestination")
@Proxy(lazy=false)
public class VacationDestination {
    @Id
    private Integer id;
    @Column
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "destinationId")
    private List<VacationPackage> vacationPackageList;

    public VacationDestination() {}

    public VacationDestination(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
