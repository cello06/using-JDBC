package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.City;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs) throws SQLException {
        return new City(
                rs.getInt("city_id"),
                rs.getString("city"),
                rs.getInt("country_id"),              // NOTE: country_id is of type smallint, which can be mapped to Java int
                rs.getTimestamp("last_update")
        );
    }
}
