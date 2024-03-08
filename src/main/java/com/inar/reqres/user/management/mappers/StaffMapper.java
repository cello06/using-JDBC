package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.Staff;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffMapper implements RowMapper<Staff> {
    @Override
    public Staff mapRow(ResultSet rs) throws SQLException {
        return new Staff(rs.getInt("staff_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("address_id"),
                rs.getString("email"),
                rs.getInt("store_id"),
                rs.getBoolean("active"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getTimestamp("last_update"));
    }
}
