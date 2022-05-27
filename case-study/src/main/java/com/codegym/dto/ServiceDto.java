package com.codegym.dto;

import com.codegym.model.service.FacilityType;
import com.codegym.model.service.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class ServiceDto implements Validator {
    private Integer serviceId;

    @NotEmpty(message = "Not empty !")
    @Pattern(regexp = "^(DV-)\\d{4}$", message = "base on DV-XXXX (x is 0-9 !)")
    private String serviceCode;

    @NotEmpty(message = "Not empty !")
    private String serviceName;

    @Positive(message = "must be positive number !")
    private Integer serviceArea;

    @Positive(message = "must be positive number !")
    private Double serviceCost;

    @Positive(message = "must be positive number !")
    private Integer serviceMaxPeople;

    @NotEmpty(message = "Not empty !")
    private String standardRoom;

    @NotEmpty(message = "Not empty !")
    private String descriptionOtherConvenience;

    @Positive(message = "must be positive number !")
    private Double poolArea;

    @Positive(message = "must be positive number !")
    private Integer numberOfFloors;

    @NotNull(message = "pls confirm your rent type !")
    private RentType rentType;

    @NotNull(message = "pls confirm your facility type !")
    private FacilityType facilityType;

    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
