package com.inar.reqres.user.management.service;

import com.inar.reqres.user.management.mappers.FilmDetailsMapper;
import com.inar.reqres.user.management.model.FilmDetails;
import com.inar.reqres.user.management.utils.DBUtils;

import java.util.List;

public class FilmDetailsService {

    public List<FilmDetails> getListOfAllFilmDetails() {
        String query = "SELECT film.film_id ,film.title ,film.description ,film.release_year,category.name AS category, " +
                "STRING_AGG(CONCAT(actor.first_name, ' ' ,actor.last_name), ',') AS actor_list " +
                "FROM film " +
                "JOIN film_category ON film.film_id = film_category.film_id " +
                "JOIN category ON category.category_id = film_category.category_id " +
                "JOIN film_actor ON film_actor.film_id = film.film_id " +
                "JOIN actor ON film_actor.actor_id = actor.actor_id " +
                "GROUP BY film.film_id,film.title,film.description,film.release_year,category.name";
        return DBUtils.executeQuery(query, new FilmDetailsMapper());
    }

    public FilmDetails getAFilmDetailByFilmId(int filmId) {
        String query = "SELECT film.film_id, film.title ,film.description ,film.release_year,category.name AS category, " +
                "STRING_AGG(CONCAT(actor.first_name, ' ' ,actor.last_name), ',') AS actor_list " +
                "FROM film " +
                "JOIN film_category ON film.film_id = film_category.film_id " +
                "JOIN category ON category.category_id = film_category.category_id " +
                "JOIN film_actor ON film_actor.film_id = film.film_id " +
                "JOIN actor ON film_actor.actor_id = actor.actor_id " +
                "WHERE film.film_id = " + filmId +
                " GROUP BY film.film_id,film.title,film.description,film.release_year,category.name";

        List<FilmDetails> filmDetailsList = DBUtils.executeQuery(query, new FilmDetailsMapper());
        return filmDetailsList.isEmpty() ? null : filmDetailsList.get(0);
    }
}
