package com.inar.reqres.user.management.mappers;

import com.inar.reqres.user.management.model.Address;
import com.inar.reqres.user.management.utils.RowMapper;

import java.sql.ResultSet;

public class AddressMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs) throws Exception {
		return new Address(rs.getInt("address_id"), rs.getString("address"), rs.getString("address2"),
				rs.getString("district"), rs.getInt("city_id"), rs.getString("postal_code"), rs.getString("phone"),
				rs.getTimestamp("last_update"));
	}

}
