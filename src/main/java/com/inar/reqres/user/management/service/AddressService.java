package com.inar.reqres.user.management.service;

import com.inar.reqres.user.management.mappers.AddressMapper;
import com.inar.reqres.user.management.model.Address;
import com.inar.reqres.user.management.utils.DBUtils;

import java.util.List;

public class AddressService {

	public List<Address> getAllAddresses() {
		String query = "SELECT * FROM address";
		return DBUtils.executeQuery(query, new AddressMapper());
	}

	public Address getAddressById(int id) {
		String query = "SELECT * FROM address WHERE address_id=" + id;
		List<Address> addressList = DBUtils.executeQuery(query, new AddressMapper());
		return addressList.isEmpty() ? null : addressList.get(0);
	}

	public List<Address> getAddressByDistrict(String district) {
		String query = "SELECT * FROM address WHERE district='" + district + "'";
		return DBUtils.executeQuery(query, new AddressMapper());
	}

}
