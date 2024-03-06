package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.Film;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet rs) throws SQLException {
        return new Film(rs.getInt("film_id"),
                rs.getString("title"),
                rs.getInt("rental_duration"),
                rs.getDouble("rental_rate"),
                rs.getInt("length"),
                rs.getDouble("replacement_cost"),
                rs.getTimestamp("last_update"));
    }
}
