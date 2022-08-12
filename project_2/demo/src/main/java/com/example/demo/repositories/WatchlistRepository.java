package com.example.demo.repositories;

import com.example.demo.models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {


    List<Watchlist> findByUserId(int userId);
    List<Watchlist> findByName(String name);
    List<Watchlist> findByUserIdAndName(int userId, String name);







    void deleteByUserIdAndMovieId(int userId,String movieId);





}