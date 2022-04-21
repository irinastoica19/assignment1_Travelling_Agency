package org.example.model;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "vacationpackage")
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
    private Integer destinationId;
    @Column
    private Integer status;

    public VacationPackage(){};

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


}
