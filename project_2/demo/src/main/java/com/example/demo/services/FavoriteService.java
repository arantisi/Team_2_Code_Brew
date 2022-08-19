package com.example.demo.services;

import com.example.demo.exceptions.DuplicateEntityException;
import com.example.demo.models.Favorite;
import com.example.demo.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;

    public List<Favorite> getFavoritesByUser(int userId) {
        return favoriteRepository.findByUserId(userId);
    }

//    public Favorite addToFavorites(Favorite favorite) {
//        return favoriteRepository.save(favorite);
//    }
    public void addToFavorites(Favorite favorite) {
        int userId = favorite.getUserId();
        String movieId = favorite.getMovieId();
        Favorite duplicate = favoriteRepository.findByUserIdAndMovieId(userId, movieId);
        if (duplicate == null) {
            favoriteRepository.save(favorite);
        } else {
            throw new DuplicateEntityException("Movie already in your Favorites");
        }
    }

    public void deleteFromFavorites(int userId,String movieId) {
        favoriteRepository.deleteByUserIdAndMovieId(userId,movieId);
    }
}