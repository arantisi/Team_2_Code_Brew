package com.example.demo.services;

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
}