package com.customer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer_Details")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name",length = 40,nullable = false)
    private String first_name;

    @Column(name = "Last_Name",length = 40)
    private String last_name;

    @Column(name = "Email",nullable = false)
    @Length(min = 5, max = 60)
    private String email;

    @Column(name = "Phone_Number",length = 10,unique = true)
    private String phone_number;

    @Column(name = "Address")
    @Length(min = 10, max = 150)
    private String address;

    @Column(name = "Date_Of_Registration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_of_registration = new Date(System.currentTimeMillis());

}
