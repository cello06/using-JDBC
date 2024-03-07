package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.Rental;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalMapper implements RowMapper<Rental> {

    @Override
    public Rental mapRow(ResultSet rs) throws SQLException {
        return new Rental(rs.getInt("rental_id"),
                rs.getTimestamp("rental_date"),
                rs.getInt("inventory_id"),
                rs.getInt("customer_id"),
                rs.getTimestamp("return_date"),
                rs.getInt("staff_id"),
                rs.getTimestamp("last_update"));
    }
}
