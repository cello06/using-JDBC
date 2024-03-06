package com.inar.reqres.user.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    private int filmId;
    private String title;
    private int rentalDuration;
    private  double rentalRate;
    private int length;
    private double replacementCost;
    private Timestamp lastUpdate;
}
