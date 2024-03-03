package com.inar.reqres.user.management.service;

import com.inar.reqres.user.management.mappers.CityMapper;
import com.inar.reqres.user.management.model.City;
import com.inar.reqres.user.management.utils.DBUtils;

import java.util.List;

public class CityService {

    public List<City> getAllCities() {
        String query = "SELECT * FROM city";
        return DBUtils.executeQuery(query, new CityMapper());
    }

    public City getCityById(int id) {
        String query = "SELECT * FROM city WHERE city_id=" + id;
        List<City> cityList = DBUtils.executeQuery(query, new CityMapper());
        return cityList.isEmpty() ? null : cityList.get(0);
    }

}
