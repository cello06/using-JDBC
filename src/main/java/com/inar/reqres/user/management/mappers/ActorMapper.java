package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.Actor;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {

	public Actor mapRow(ResultSet rs) throws SQLException {
		return new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"),
				rs.getTimestamp("last_update"));
	}

}
