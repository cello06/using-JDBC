package com.inar.reqres.user.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

// Entity class representing a Actor
	private int actorId;

	private String firstName;

	private String lastName;

	private Timestamp lastUpdate;

}
