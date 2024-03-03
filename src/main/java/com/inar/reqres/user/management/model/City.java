package com.inar.reqres.user.management.model;

import java.sql.Timestamp;

public record City(int cityId, String city, int countryId, Timestamp lastUpdate) {
}
