package org.example.model;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "vacationpackage")
@Proxy(lazy=false)
public class VacationPackage {

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer price;
    @Column
    private Integer period;
    @Column
    private String extraDetails;
    @Column
    private Integer availablePlaces;
    @Column
    private Integer status;
    private Integer destinationId;
    @ManyToOne(fetch = FetchType.LAZY)
    private VacationDestination vacationDestination;

    public VacationPackage(){}

    public VacationPackage(Integer id, String name, Integer price, Integer period, String extraDetails, Integer availablePlaces, Integer destinationId, Integer status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.period = period;
        this.extraDetails = extraDetails;
        this.availablePlaces = availablePlaces;
        this.destinationId = destinationId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPeriod() {
        return period;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public Integer getAvailablePlaces() {
        return availablePlaces;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public void setAvailablePlaces(Integer availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }
}
