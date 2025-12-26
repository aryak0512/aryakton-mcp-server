package com.aryak.mcp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "residents")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long residentId;
    private String name;
    private String address;

    protected Resident() {
    }

    public Resident(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getResidentId() {
        return residentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
