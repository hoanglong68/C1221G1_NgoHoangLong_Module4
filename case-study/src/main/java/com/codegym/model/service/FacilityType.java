package com.codegym.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facilityTypeId;
    private String facilityTypeName;

    @OneToMany(mappedBy = "facilityType")
    List<Service> serviceList;

    public FacilityType() {
    }

    public Integer getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(Integer facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
