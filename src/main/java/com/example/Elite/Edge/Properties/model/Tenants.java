package com.example.Elite.Edge.Properties.model;

import com.example.Elite.Edge.Properties.constants.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
public class Tenants {

    @Id
    @SequenceGenerator(name = "tenant_sequence",
            sequenceName = "units_seq",
            allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tenant_sequence"

    )
    private Long id;


    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(nullable = false)
    private String address;

    @Column
    private String occupation;

    @Column
    private Double income;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status tenantStatus;


    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "unit_id")
    private Units units;

    @OneToOne(mappedBy = "tenants")
    private Lease lease;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Lease getLeases(){
        return lease;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public Status getTenantStatus(){
        return tenantStatus;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setTenantStatus(Status tenantStatus) {
        this.tenantStatus = tenantStatus;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public void setLease(Lease lease){
        this.lease = lease;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Units getUnit() {
        return units;
    }

    public void setUnit(Units units) {
        this.units = units;
    }



    // Optional: Custom Constructor
    public Tenants(String firstName, String lastName, String email, String phone, LocalDate dob,
                   String address, String occupation, Double income, Status tenantStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
        this.occupation = occupation;
        this.income = income;
        this.tenantStatus = tenantStatus;
    }


    @Override
    public String toString() {
        return "Tenants{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", occupation='" + occupation + '\'' +
                ", income=" + income +
                ", unit=" + (units != null ? units.getId() : "null") +
                '}';
    }


}
