package com.inar.reqres.user.management.service;

import com.inar.reqres.user.management.mappers.FilmMapper;
import com.inar.reqres.user.management.model.Film;
import com.inar.reqres.user.management.utils.DBUtils;

import java.util.List;

public class FilmService {
    public List<Film> getAllFilms(){
        String query = "SELECT * FROM film;";
        return DBUtils.executeQuery(query,new FilmMapper());
    }

    public Film getFilmById(int filmId){
        String query = "SELECT * FROM film WHERE film_id = " + filmId;
        List<Film> filmList = DBUtils.executeQuery(query,new FilmMapper());
        return  filmList.isEmpty() ? null : filmList.get(0);
    }

}
