package com.inar.reqres.user.management.service;

import com.inar.reqres.user.management.mappers.RentalMapper;
import com.inar.reqres.user.management.model.Rental;
import com.inar.reqres.user.management.utils.DBUtils;

import java.util.List;

public class RentalService {
    public List<Rental> getListOfAllRentals() {
        String query = "SELECT * FROM rental;";
        return DBUtils.executeQuery(query, new RentalMapper());
    }

    public Rental getARentalByRentalId(int rentalId) {
        String query = "SELECT * FROM rental WHERE rental_id = " + rentalId;
        List<Rental> rentalList = DBUtils.executeQuery(query, new RentalMapper());

        return rentalList.isEmpty() ? null : rentalList.get(0);
    }
}
