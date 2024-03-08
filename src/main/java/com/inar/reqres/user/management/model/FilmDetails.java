package com.inar.reqres.user.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDetails {

    private String filmTitle;

    private String description;

    private int releaseYear;

    private String categoryName;

    private String actorFirstName;

    private String actorLastName;

    private int actorId;
}
