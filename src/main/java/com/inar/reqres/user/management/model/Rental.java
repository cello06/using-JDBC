package com.inar.reqres.user.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    private int rentalId;

    private Timestamp rentalDate;

    private int inventoryId;

    private int customerId;

    private Timestamp returnDate;

    private int staffId;

    private Timestamp lastUpdate;
}
