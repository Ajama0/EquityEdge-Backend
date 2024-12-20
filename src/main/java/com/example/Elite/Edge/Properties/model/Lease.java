package com.example.Elite.Edge.Properties.model;


import com.example.Elite.Edge.Properties.constants.Status;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Lease {

    @Id
    @SequenceGenerator(name = "Lease_sequence",
            sequenceName = "lease_seq",
            allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Lease_sequence"

    )
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "rent_amount", nullable = false)
    private Double rentAmount;

    @Column(name = "deposit_amount", nullable = false)
    private Double depositAmount;

    @Column(name = "termination_notice_period", nullable = true)
    private Integer terminationNoticePeriod;

    @Column(name = "agreement_document")
    private String agreementDocument;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDate updatedDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Units unit;

    @OneToOne
    @JoinColumn(name = "tenant_id")
    private Tenants tenants;

    //payment and leases
    @OneToMany(mappedBy = "lease")
    private List<Payments> payments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public Integer getTerminationNoticePeriod() {
        return terminationNoticePeriod;
    }

    public String getAgreementDocument() {
        return agreementDocument;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public Units getUnit() {
        return unit;
    }

    public Tenants getTenants() {
        return tenants;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setDepositAmount(Double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public void setTerminationNoticePeriod(Integer terminationNoticePeriod) {
        this.terminationNoticePeriod = terminationNoticePeriod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAgreementDocument(String agreementDocument) {
        this.agreementDocument = agreementDocument;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public void setTenants(Tenants tenants) {
        this.tenants = tenants;
    }


    public Lease(LocalDate startDate, LocalDate endDate, Double rentAmount, Double depositAmount,
                 Integer terminationNoticePeriod, String agreementDocument, Status leaseStatus) {
        this.startDate = LocalDate.now();
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.depositAmount = depositAmount;
        this.terminationNoticePeriod = terminationNoticePeriod;
        this.agreementDocument = agreementDocument;
        this.createdDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
        this.status= leaseStatus;

    }

    @Override
    public String toString() {
        return "Lease{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rentAmount=" + rentAmount +
                ", depositAmount=" + depositAmount +
                ", terminationNoticePeriod=" + terminationNoticePeriod +
                ", agreementDocument='" + agreementDocument + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", unit=" + unit +
                ", tenants=" + tenants +
                ", status =" + status +
                '}';
    }
}
