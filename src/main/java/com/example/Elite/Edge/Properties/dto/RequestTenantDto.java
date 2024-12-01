package com.example.Elite.Edge.Properties.dto;

import com.example.Elite.Edge.Properties.constants.Status;
import com.example.Elite.Edge.Properties.constants.unitStatus;
import com.example.Elite.Edge.Properties.constants.unitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestTenantDto {





    private String firstName;


    private String lastName;


    private String email;


    private String phone;

    private LocalDate dob;


    private String address;


    private String occupation;


    private Double income;

    private Status tenantStatus;




}