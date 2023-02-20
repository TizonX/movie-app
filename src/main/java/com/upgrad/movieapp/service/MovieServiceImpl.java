package com.upgrad.movieapp.service;

import com.upgrad.movieapp.dao.MovieDao;
import com.upgrad.movieapp.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public List<Movie> acceptMultipleMovieDetails(List<Movie> movies) {
        List<Movie> movieList = new ArrayList<>();
        for (Movie movie : movieList){
            movieList.add(acceptMovieDetails(movie));
        }
        return movieList;
    }

    @Override
    public Movie getMovieDetails(int id) {
        return movieDao.findById(id).get();
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) {
        Movie savedMovie = getMovieDetails(id);
        savedMovie.setMovieDiscription(movie.getMovieDiscription());
        savedMovie.setMovieName(movie.getMovieName());
        savedMovie.setDuration(movie.getDuration());
        savedMovie.setReleaseDate(movie.getReleaseDate());
        savedMovie.setTrailerUrl(movie.getTrailerUrl());
        savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
        movieDao.save(savedMovie);
        return savedMovie;
    }

    @Override
    public boolean deleteMovie(int id) {
        Movie movie = getMovieDetails(id);
        if(movie == null){
            return false;
        }
        movieDao.delete(movie);
        return true;

    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Page<Movie> getPaginatedMovieDetails(Pageable pageable) {
        return movieDao.findAll(pageable);
    }
}
