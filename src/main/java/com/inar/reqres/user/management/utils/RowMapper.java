package com.inar.reqres.user.management.utils;

import java.sql.ResultSet;

@FunctionalInterface
public interface RowMapper<T> {

	T mapRow(ResultSet rs) throws Exception;

}
