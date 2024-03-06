package com.inar.reqres.user.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private int paymentId;

    private int customerId;

    private int staffId;

    private int rentalId;

    private double amount;

    private Timestamp paymentDate;

}
