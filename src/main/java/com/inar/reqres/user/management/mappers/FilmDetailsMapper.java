package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.FilmDetails;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmDetailsMapper implements RowMapper<FilmDetails> {
    @Override
    public FilmDetails mapRow(ResultSet rs) throws SQLException {
        return new FilmDetails(rs.getInt("film_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getInt("release_year"),
                rs.getString("category"),
                rs.getString("actor_list"));
    }
}
