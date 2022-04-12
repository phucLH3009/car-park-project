package com.phuclh.carparkproject.dto.response;

import com.phuclh.carparkproject.entity.ParkingLot;

public class CarResponseDTO {

    private String licensePlate;
    private String type;
    private String color;
    private String company;
    private ParkingLot parkingLot;

    public CarResponseDTO() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getParkingLotName() {
        return parkingLot.getName();
    }

    public void setParkingLotName(ParkingLot parkingLot) {
        this.parkingLot.setName(parkingLot.getName());
    }
}
