package com.phuclh.carparkproject.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parkId", length = 20)
    private long id;

    @Min(0)
    @Column(name = "parkArea", length = 20)
    @NotNull(message = "area required")
    private long area;

    @Column(name = "parkName", length = 50)
    @NotBlank(message = "name required")
    private String name;

    @Column(name = "parkPlace", length = 50)
    @NotBlank(message = "place required")
    private String place;

    @Min(0)
    @Column(name = "parkPrice", length = 50)
    private long price;

    @Column(name = "parkStatus", length = 50)
    @NotBlank(message = "status required")
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    public ParkingLot() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
