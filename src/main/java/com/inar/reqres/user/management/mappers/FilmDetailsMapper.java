package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.FilmDetails;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmDetailsMapper implements RowMapper<FilmDetails> {
    @Override
    public FilmDetails mapRow(ResultSet rs) throws SQLException {
        return new FilmDetails(rs.getString("title"),
                rs.getString("description"),
                rs.getInt("release_year"),
                rs.getString("name"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("actor_id"));
    }
}
